package net.roundya.restlayer.place;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;

import org.springframework.data.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public interface ReactivePlaceRepository extends ReactiveMongoRepository<Place, String> {
    Flux<Place> findByLocationNear(GeoJsonPoint location, Distance distance);
} 
