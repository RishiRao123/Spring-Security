package org.raoamigos.springsecurity2.service;

import org.raoamigos.springsecurity2.entity.User;
import org.raoamigos.springsecurity2.repository.UserRepository;
import org.raoamigos.springsecurity2.security.CustomUserDetails;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found: " + username));

        return new CustomUserDetails(user);
    }
}