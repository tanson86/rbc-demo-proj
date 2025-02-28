package com.example.rbc.springbootdemo.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    public static final String SPRING_TOPIC = "spring-topic";

//    @Bean
//    public NewTopic topic(){
//        return TopicBuilder.name(SPRING_TOPIC).build();
//    }
}
