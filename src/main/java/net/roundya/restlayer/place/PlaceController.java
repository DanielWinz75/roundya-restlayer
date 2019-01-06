package net.roundya.restlayer.place;

import java.util.List;

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

@RestController
@RequestMapping("/places")
public class PlaceController {

    private PlaceRepository placeRepository;

    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @PostMapping
    public void addPlace(@RequestBody Place place) {
        double longitute = Double.valueOf(place.getLong());
        double latitute = Double.valueOf(place.getLat());
        GeoJsonPoint p = new GeoJsonPoint(longitute, latitute);
        place.setLocation(p);
        placeRepository.insert(place);
    }

    @GetMapping
    public List<Place> getPlaces() {
        return placeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Place getPlaceById(@PathVariable String id) {
        return placeRepository.findById(id).get();
    }

    @GetMapping("/near/{id}")
    public List<Place> getPlaceNear(@PathVariable String id) {

        Place place = placeRepository.findById(id).get();
        Assert.notNull(place, "Place not found");

        double longitute = Double.valueOf(place.getLong());
        double latitute = Double.valueOf(place.getLat());

        GeoJsonPoint point = new GeoJsonPoint(longitute, latitute);

        Distance dist = new Distance(PlaceConstants.MAX_DISTANCE_KILOMETERS, Metrics.KILOMETERS);
        return placeRepository.findByLocationNear(point, dist);
    }

    @PutMapping("/{id}")
    public void editPlace(@PathVariable String id, @RequestBody Place place) {
        Place existingPlace = placeRepository.findById(id).get();
        Assert.notNull(existingPlace, "Place not found");
        placeRepository.save(place);
    }

    @DeleteMapping("/{id}")
    public void deletePlace(@PathVariable String id) {
        Place placeToDel = placeRepository.findById(id).get();
        placeRepository.delete(placeToDel);
    }
}