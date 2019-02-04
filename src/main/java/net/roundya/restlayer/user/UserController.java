package net.roundya.restlayer.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.roundya.restlayer.errorhandling.UserExistsException;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    ApplicationUserRepository userRepository;

    @Autowired
    ReactiveUserRepository reactiveUserRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public Mono<ApplicationUser> signUp(@Valid @RequestBody ApplicationUser user) throws UserExistsException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserExistsException("Username allready exists.");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserExistsException("Email address allready exists.");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return reactiveUserRepository.save(user);
    }
}