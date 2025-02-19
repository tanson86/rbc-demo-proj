package com.example.rbc.springbootdemo.mapper;

import com.example.rbc.springbootdemo.dto.PostDto;
import com.example.rbc.springbootdemo.dto.UserDto;
import com.example.rbc.springbootdemo.entity.Post;
import com.example.rbc.springbootdemo.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = PostMapper.class)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "postDtoList", source = "posts")
    UserDto userToUserDto(User user);

    @InheritInverseConfiguration
    User userDtoToUser(UserDto userDto);
}
