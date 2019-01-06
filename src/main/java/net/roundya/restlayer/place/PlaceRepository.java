package net.roundya.restlayer.place;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public interface PlaceRepository extends MongoRepository<Place, String> {
    List<Place> findByLocationNear(GeoJsonPoint location, Distance distance);
}