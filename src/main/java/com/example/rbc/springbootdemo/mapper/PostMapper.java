package com.example.rbc.springbootdemo.mapper;

import com.example.rbc.springbootdemo.dto.PostDto;
import com.example.rbc.springbootdemo.entity.Post;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "title", source = "title")
//    @Mapping(target = "content", source = "content")
   @Mapping(target = "userId", source = "user.id")
    PostDto postToPostDto(Post post);

    @InheritInverseConfiguration
    Post postDtoToPost(PostDto postDto);
}
