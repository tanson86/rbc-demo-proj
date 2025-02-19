package com.example.rbc.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.time.Duration;

@Configuration
public class RedisClientConfig {

    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory(){
        System.out.println("Using custom LettuceConnectionFactory ---- TANSON");
        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder().commandTimeout(Duration.ofMillis(333)).build();
        return  new LettuceConnectionFactory(new RedisStandaloneConfiguration(), clientConfig);
    }
}
