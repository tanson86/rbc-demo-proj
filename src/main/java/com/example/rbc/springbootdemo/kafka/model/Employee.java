package com.example.rbc.springbootdemo.kafka.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
    @JsonProperty("name")
    String name;
    @JsonProperty("age")
    int age;
    @JsonProperty("admin")
    boolean admin;
    @JsonProperty("addressList")
    List<Address> addressList = new ArrayList<>();
}
