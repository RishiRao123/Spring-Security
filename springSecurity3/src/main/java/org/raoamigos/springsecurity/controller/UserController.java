package org.raoamigos.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.raoamigos.springsecurity.entity.User;
import org.raoamigos.springsecurity.repsoitory.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        var u = userRepository.findByUsername(user.getUsername());

        if (u.isEmpty())
            return "false";

        return "success";
    }
}
