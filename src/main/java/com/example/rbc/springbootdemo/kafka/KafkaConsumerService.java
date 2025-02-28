package com.example.rbc.springbootdemo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = KafkaConfig.SPRING_TOPIC,groupId = "user-group")
    public void consumer(String input){
        System.out.println(input);
    }
}
