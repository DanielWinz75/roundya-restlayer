package net.roundya.restlayer.place;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaceRepository extends MongoRepository<Place, String> {}