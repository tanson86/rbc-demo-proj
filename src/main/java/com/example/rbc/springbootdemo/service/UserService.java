package com.example.rbc.springbootdemo.service;

import com.example.rbc.springbootdemo.aspect.ExecutionTimeLogger;
import com.example.rbc.springbootdemo.dto.UserDto;
import com.example.rbc.springbootdemo.entity.User;
import com.example.rbc.springbootdemo.exception.NotFoundException;
import com.example.rbc.springbootdemo.mapper.UserMapper;
import com.example.rbc.springbootdemo.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @ExecutionTimeLogger
    @Cacheable(value = "usersLazy")
    public List<UserDto> findAllUsersLazy(){
        Optional<List<User>> users = Optional.ofNullable(userRepository.findAll());
        return convertUserToDto(users);
    }

    @ExecutionTimeLogger
    @Cacheable(value = "usersEager",key="'eager'")
    public List<UserDto> findAllUsersEager() {
        Optional<List<User>> users = Optional.ofNullable(userRepository.findAllEager());
        return convertUserToDto(users);
    }

    private List<UserDto> convertUserToDto(Optional<List<User>> users){
        if(!users.isPresent())
            return List.of();
        List<UserDto> userDto = new ArrayList<>();
        for(User user:users.get()) {
            //System.out.println(user);
            userDto.add(userMapper.userToUserDto(user));
        }
        return userDto;
    }

    @ExecutionTimeLogger
    public UserDto findUserById(Integer id){
        return userRepository.findById(id).map(userMapper::userToUserDto).orElseThrow(()->new NotFoundException("User not found"));
    }
}
