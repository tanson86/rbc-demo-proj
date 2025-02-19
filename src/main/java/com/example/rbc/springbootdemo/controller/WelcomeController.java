package com.example.rbc.springbootdemo.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
//@SecurityRequirement(name = "basicAuth")
public class WelcomeController {
    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public String admin(Principal principal, Authentication auth){
        auth.getAuthorities().forEach(System.out::println);
        return "Welcome admin!!! "+principal.getName();
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public String user(Principal principal, Authentication auth){
        auth.getAuthorities().forEach(System.out::println);
        return "Welcome user!!! "+principal.getName();
    }
}
