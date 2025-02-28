package com.example.rbc.springbootdemo.kafka.generator;


import com.example.rbc.springbootdemo.kafka.model.Address;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Random;

@Service
class AddressGenerator {

    private final Random random;
    private final Address[] addresses;

    public AddressGenerator() {
        final String DATAFILE = "src/main/resources/data/address.json";
        final ObjectMapper mapper;
        random = new Random();
        mapper = new ObjectMapper();
        try {
            addresses = mapper.readValue(new File(DATAFILE), Address[].class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private int getIndex() {
        return random.nextInt(4);
    }

    public Address getNextAddress() {
        return addresses[getIndex()];
    }

}

