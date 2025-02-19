package com.example.rbc.springbootdemo.controller;

import com.example.rbc.springbootdemo.service.TokenService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name = "basicAuth")
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @RequestMapping("/token")
    public String token(Authentication authentication){
        LOG.info("Token requested for user '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.info("Token generated {}", token);
        return token;
    }
}
