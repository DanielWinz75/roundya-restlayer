package net.roundya.restlayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan ({"net.roundya.restlayer", "net.roundya.restlayer.config"})
@EnableMongoRepositories ({"net.roundya.restlayer.user", "net.roundya.restlayer.place"})
@EnableReactiveMongoRepositories ("net.roundya.restlayer.place")
public class Application {

	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
