package com.artemnizhnyk.testcontainers.web.mapper;

import com.artemnizhnyk.testcontainers.model.Post;
import com.artemnizhnyk.testcontainers.web.dto.PostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper extends Mappable<Post, PostDto> {
}
