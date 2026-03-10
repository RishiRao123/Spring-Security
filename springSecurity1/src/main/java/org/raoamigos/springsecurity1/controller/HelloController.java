package org.raoamigos.springsecurity1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String hello(HttpServletRequest req) {
        return "<h1>Hello World!</h1>" + req.getSession().getId();
    }
}
