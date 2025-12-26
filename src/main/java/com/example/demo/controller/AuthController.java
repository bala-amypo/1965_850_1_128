package com.example.demo.controller;

import com.example.demo.config.JwtTokenProvider;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwtProvider;

    public AuthController(AuthenticationManager authManager,
                          JwtTokenProvider jwtProvider,
                          PasswordEncoder encoder) {
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        return jwtProvider.generateToken(auth);
    }
}
