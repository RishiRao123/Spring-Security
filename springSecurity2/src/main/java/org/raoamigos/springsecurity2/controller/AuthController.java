package org.raoamigos.springsecurity2.controller;

import lombok.RequiredArgsConstructor;
import org.raoamigos.springsecurity2.entity.User;
import org.raoamigos.springsecurity2.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        authService.register(user);

        return "User registered successfully";
    }
}