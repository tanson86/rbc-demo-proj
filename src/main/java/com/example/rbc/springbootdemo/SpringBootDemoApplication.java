package com.example.rbc.springbootdemo;

import com.example.rbc.springbootdemo.config.RsaKeyProperties;
import com.example.rbc.springbootdemo.controller.util.ImmutableCredentials;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@EnableConfigurationProperties({RsaKeyProperties.class, ImmutableCredentials.class})
@SpringBootApplication
@EnableCaching
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}
