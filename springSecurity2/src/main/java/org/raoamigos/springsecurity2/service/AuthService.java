package org.raoamigos.springsecurity2.service;

import lombok.RequiredArgsConstructor;
import org.raoamigos.springsecurity2.entity.User;
import org.raoamigos.springsecurity2.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");

        return userRepository.save(user);
    }
}