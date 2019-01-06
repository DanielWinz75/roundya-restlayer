package net.roundya.restlayer.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.roundya.restlayer.errorhandling.EmailExistsException;
import net.roundya.restlayer.errorhandling.UserNameExistsException;

@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) throws UserNameExistsException {
        if( applicationUserRepository.findByUsername(user.getUsername()) != null ) {
            throw new UserNameExistsException("Username allready exists.");
        }
        // if( applicationUserRepository.findByEmail(user.getEmail()) != null ) {
        //     throw new EmailExistsException("Email address allready exists.");
        // }        
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }
}