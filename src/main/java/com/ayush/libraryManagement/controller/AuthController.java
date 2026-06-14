package com.ayush.libraryManagement.controller;

import com.ayush.libraryManagement.dto.LoginRequest;
import com.ayush.libraryManagement.dto.LoginResponse;
import com.ayush.libraryManagement.security.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(    "/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        if (!request.getUsername().equals("admin")
                || !request.getPassword().equals("admin123")) {

            throw new RuntimeException("Invalid username or password");
        }

        String token = jwtService.generateToken(
                request.getUsername());

        return new LoginResponse(token);
    }
}
