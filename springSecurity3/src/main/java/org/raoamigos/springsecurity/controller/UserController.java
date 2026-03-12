package org.raoamigos.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.raoamigos.springsecurity.entity.User;
import org.raoamigos.springsecurity.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
       return userService.login(user);
    }
}
