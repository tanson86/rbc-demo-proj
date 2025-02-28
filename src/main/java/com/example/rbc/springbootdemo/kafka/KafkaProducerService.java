package com.example.rbc.springbootdemo.kafka;

import com.example.rbc.springbootdemo.kafka.generator.EmployeeGenerator;
import com.example.rbc.springbootdemo.kafka.model.Employee;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, Employee> kafkaTemplate;
    private final EmployeeGenerator employeeGenerator;

    public KafkaProducerService(KafkaTemplate<String, Employee> kafkaTemplate,EmployeeGenerator employeeGenerator) {
        this.kafkaTemplate = kafkaTemplate;
        this.employeeGenerator = employeeGenerator;
    }

    public boolean added(){
        kafkaTemplate.send(KafkaConfig.SPRING_TOPIC,employeeGenerator.getNextEmployee());
        return true;
    }
}
