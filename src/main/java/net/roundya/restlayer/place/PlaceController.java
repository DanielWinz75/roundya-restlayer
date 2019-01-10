package net.roundya.restlayer.place;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Mono<Place> addPlace(@Valid @RequestBody Place place) {
        // --- Sample Request ----
        // {
        // "subject": "Ich",
        // "predicate": "teste",
        // "object": "wie doof",
        // "text": "und doof",
        // "location": {
        // "type": "Point",
        // "coordinates": [-122.414, 37.776]
        // }
        // }
        return reactivePlaceRepository.save(place);
    }

    @GetMapping("/{id}")
    public Mono<Place> getPlaceById(@PathVariable String id) {
        return reactivePlaceRepository.findById(id);
    }

    @GetMapping("/near/{id}")
    public Flux<Place> getPlaceNear(@PathVariable String id) {        
        System.out.println(".... In");

        // TBD: Would be faster if this was a get function receiving the coordinates directly
        Place place = placeRepository.findById(id).get();
        Assert.notNull(place, "Place not found");

        System.out.println("get place near: " + place.getId());

        double longitute = place.getLocation().getX();
        double latitute = place.getLocation().getY();
        
        GeoJsonPoint point = new GeoJsonPoint(longitute, latitute);
        Distance dist = new Distance(PlaceConstants.MAX_DISTANCE_KILOMETERS, Metrics.KILOMETERS);

        return reactivePlaceRepository.findByLocationNear(point, dist);
    }


    // TBD: Not updating yet, only adding ...
    @PutMapping("/{id}")
    public Mono<Place> editPlace(@PathVariable String id, @Valid @RequestBody Place place) {        
        Place existingPlace = placeRepository.findById(id).get();
        Assert.notNull(existingPlace, "Place not found");
        return reactivePlaceRepository.save(place);
    }

    // @DeleteMapping("/{id}")
    // public void deletePlace(@PathVariable String id) {
    //     Place placeToDel = placeRepository.findById(id).get();
    //     placeRepository.delete(placeToDel);
    // }
}