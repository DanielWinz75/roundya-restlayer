package net.roundya.restlayer.user;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReactiveUserRepository extends ReactiveMongoRepository<ApplicationUser, String> {

    @Query("{ 'Username' : ?0 }")
    ApplicationUser findByUsername(String username);

    @Query("{ 'Email' : ?0 }")
    ApplicationUser findByEmail(String email);

}