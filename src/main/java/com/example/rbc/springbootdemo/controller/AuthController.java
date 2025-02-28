package com.example.rbc.springbootdemo.controller;

import com.example.rbc.springbootdemo.service.TokenService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@SecurityRequirement(name = "basicAuth")
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    private final TokenService tokenService;
private int counter = 0;
    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication, HttpSession session){
        LOG.info("Token requested for user '{}'", authentication.getName());
        session.setAttribute("Count", counter+=1 );
        Optional<String> tokenFromRedis = Optional.ofNullable((String) session.getAttribute("Token"));
        if(tokenFromRedis.isPresent())
            return tokenFromRedis.get();
        String token = tokenService.generateToken(authentication);
        //session.setAttribute("Token", token);
        LOG.info("Token generated {}", token);
        return token;
    }
}
