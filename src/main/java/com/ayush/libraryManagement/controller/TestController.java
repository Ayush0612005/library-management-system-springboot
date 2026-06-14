package com.ayush.libraryManagement.controller;

import com.ayush.libraryManagement.security.JwtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final JwtService jwtService;

    public TestController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/test/token")
    public String generateToken() {
        return jwtService.generateToken("ayush");
    }
}
