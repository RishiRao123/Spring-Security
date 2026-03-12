package org.raoamigos.springsecurity.service;

import lombok.RequiredArgsConstructor;
import org.raoamigos.springsecurity.entity.User;
import org.raoamigos.springsecurity.repsoitory.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String login(User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken (
                user.getUsername(),
                user.getPassword())
        );
//        var dbUser = userRepository.findByUsername(user.getUsername());

//        if (dbUser.isEmpty()) {
//            return "User not found";
//        }

        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(user)
        }

        return "Failure";
    }

}
