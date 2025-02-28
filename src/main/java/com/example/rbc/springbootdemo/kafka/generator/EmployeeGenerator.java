package com.example.rbc.springbootdemo.kafka.generator;

import com.example.rbc.springbootdemo.kafka.model.Address;
import com.example.rbc.springbootdemo.kafka.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Random;

@Service
public class EmployeeGenerator {
    private final Random random;
    private final Employee[] employee;
    private final AddressGenerator addressGenerator;

    public EmployeeGenerator(AddressGenerator addressGenerator) {
        final String DATAFILE = "src/main/resources/data/employee.json";
        final ObjectMapper mapper;
        random = new Random();
        mapper = new ObjectMapper();
        this.addressGenerator = addressGenerator;
        try {
            employee = mapper.readValue(new File(DATAFILE), Employee[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getIndex() {
        return random.nextInt(4);
    }

    public Employee getNextEmployee() {
        Employee e =  employee[getIndex()];
        e.setAddressList(List.of(addressGenerator.getNextAddress()));
        return e;
    }
}
