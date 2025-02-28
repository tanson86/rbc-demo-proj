package com.example.rbc.springbootdemo.controller;

import com.example.rbc.springbootdemo.controller.util.ImmutableCredentials;
import com.example.rbc.springbootdemo.kafka.KafkaProducerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
//@SecurityRequirement(name = "basicAuth")
public class WelcomeController {

    private final ImmutableCredentials immutableCredentials;
    private final KafkaProducerService kafkaProducerService;

    public WelcomeController(ImmutableCredentials immutableCredentials, KafkaProducerService kafkaService) {
        this.immutableCredentials = immutableCredentials;
        this.kafkaProducerService = kafkaService;
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public String admin(Principal principal, Authentication auth){
        //auth.getAuthorities().forEach(System.out::println);
        return "Welcome admin!!! "+principal.getName();
    }

    @GetMapping("/user")
    //@PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public String user(Principal principal, Authentication auth) throws InterruptedException {
        //auth.getAuthorities().forEach(System.out::println);
        for(int i=0;i<2;i++){
            kafkaProducerService.added();
            Thread.sleep(2000);
        }
        return "Welcome user!!! "+principal.getName();
    }

    @GetMapping("/prop")
    public String configProperties(){
        return this.immutableCredentials.authMethod()+"-"+immutableCredentials.password()+"-"+immutableCredentials.username();
    }
}
