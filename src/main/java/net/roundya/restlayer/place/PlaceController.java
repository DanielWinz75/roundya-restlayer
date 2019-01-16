package net.roundya.restlayer.place;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.roundya.restlayer.errorhandling.PlaceNotExistingException;
import net.roundya.restlayer.errorhandling.UserNotAuthorizedException;
import net.roundya.restlayer.security.JWTAuthorizationFilter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    ReactivePlaceRepository reactivePlaceRepository;

    @Autowired
    PlaceRepository placeRepository;

    @GetMapping
    public Flux<Place> getPlaces() {
        return reactivePlaceRepository.findAll();
    }

    @PostMapping
    public Mono<Place> addPlace(@Valid @RequestBody Place place, HttpServletRequest request) {
        // --- Sample Request ----
        // {
        // "subject" : "Wir",
        // "predicate" : "laden ein zu",
        // "object" : "einer Party",
        // "text" : "mit Bier und Wein",
        // "location": {
        // "type": "Point",
        // "coordinates": [-122.414023, 37.776023]
        // }
        // }

        String user = JWTAuthorizationFilter.getUserFromToken(request);
        place.setOwner(user);
        return reactivePlaceRepository.save(place);
    }

    @GetMapping("/{id}")
    public Mono<Place> getPlaceById(@PathVariable String id) {
        return reactivePlaceRepository.findById(id);
    }

    @PostMapping("/near")
    public Flux<Place> getPlaceNear(@Valid @RequestBody Place place) {
        double longitute = place.getLocation().getX();
        double latitute = place.getLocation().getY();

        GeoJsonPoint point = new GeoJsonPoint(longitute, latitute);
        Distance dist = new Distance(PlaceConstants.MAX_DISTANCE_KILOMETERS, Metrics.KILOMETERS);

        return reactivePlaceRepository.findByLocationNear(point, dist);
    }

    // @PreAuthorize("hasRole('ROLE_user')") --> could be interesting once
    @PutMapping("/{id}")
    public Mono<Place> editPlace(
        @PathVariable("id") String id, 
        @Valid @RequestBody Place place, 
        HttpServletRequest request) throws PlaceNotExistingException, UserNotAuthorizedException {

        if(!placeRepository.existsById(id)) {
            throw new PlaceNotExistingException("Required place doesn't exist.");
        }

        String user = JWTAuthorizationFilter.getUserFromToken(request);
        String placeOwner = placeRepository.findById(id).get().getOwner();
        if (!user.equals(placeOwner)) {
            throw new UserNotAuthorizedException("No rights to edit/update.");
        }

        place.setId(id);
        place.setOwner(user);
        return reactivePlaceRepository.save(place);
    }

    // @DeleteMapping("/{id}")
    // public void deletePlace(@PathVariable String id) {
    // Place placeToDel = placeRepository.findById(id).get();
    // placeRepository.delete(placeToDel);
    // }
}