package com.example.rbc.springbootdemo.kafka.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
    @JsonProperty("street")
    String street;
    @JsonProperty("code")
    String code;
}
