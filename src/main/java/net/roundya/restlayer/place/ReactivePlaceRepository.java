package net.roundya.restlayer.place;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

public interface ReactivePlaceRepository extends ReactiveMongoRepository<Place, String> {
    Flux<Place> findByLocationNear(Point location, Distance distance);
} 
