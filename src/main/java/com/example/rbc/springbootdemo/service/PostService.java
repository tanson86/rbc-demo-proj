package com.example.rbc.springbootdemo.service;

import com.example.rbc.springbootdemo.aspect.ExecutionTimeLogger;
import com.example.rbc.springbootdemo.dto.PostDto;
import com.example.rbc.springbootdemo.mapper.PostMapper;
import com.example.rbc.springbootdemo.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @ExecutionTimeLogger
    public void savePost(PostDto postDto) {
        this.postRepository.save(postMapper.postDtoToPost(postDto));
    }
}
