package com.example.rbc.springbootdemo.controller;

import com.example.rbc.springbootdemo.dto.PostDto;
import com.example.rbc.springbootdemo.dto.UserDto;
import com.example.rbc.springbootdemo.service.PostService;
import com.example.rbc.springbootdemo.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@SecurityRequirement(name = "basicAuth")
public class PostController {

    private final UserService userService;
    private final PostService postService;
    public PostController(UserService userService,PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }


    @GetMapping("/usersLazy")
    public ResponseEntity<List<UserDto>> getAllUserWithPostsLazy(){
        return new ResponseEntity<List<UserDto>>(userService.findAllUsersLazy(),HttpStatus.OK);
    }


    @GetMapping("/usersEager")
    public ResponseEntity<List<UserDto>> getAllUserWithPostsEager(){
        return new ResponseEntity<List<UserDto>>(userService.findAllUsersEager(),HttpStatus.OK);
    }

    @PostMapping("/addPost")
    public ResponseEntity<?> addPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            // Handle errors
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errors);
        }
        // Process valid postDTO
        UserDto userDto = userService.findUserById(Integer.valueOf(postDto.getUserId()));
        postService.savePost(postDto);
        return ResponseEntity.ok("Post added successfully");
    }
}
