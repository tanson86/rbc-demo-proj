package com.example.rbc.springbootdemo.dto;

import com.example.rbc.springbootdemo.entity.User;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto implements Serializable {
    private Integer id;
    @NotEmpty(message = "Title cannot be empty")
    @Size(min = 2, message = "Title must be at least 3 characters long")
    private String title;
    @NotEmpty(message = "Content cannot be empty")
    @Size(min = 2, message = "Content must be at least 10 characters long")
    private String content;
    @NotNull(message = "userId cannot be null")
    @Positive(message = "userId must be a valid positive number")
    private String userId;
}
