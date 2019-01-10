package net.roundya.restlayer.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.roundya.restlayer.errorhandling.UserExistsException;

@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(ApplicationUserRepository userRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) throws UserExistsException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserExistsException("Username allready exists.");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserExistsException("Email address allready exists.");
        }       
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}