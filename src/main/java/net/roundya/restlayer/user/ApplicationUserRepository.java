package net.roundya.restlayer.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, String> {

    @Query("{ 'Username' : ?0 }")
    ApplicationUser findByUsername(String username);

    @Query("{ 'Email' : ?0 }")
    ApplicationUser findByEmail(String email);

}