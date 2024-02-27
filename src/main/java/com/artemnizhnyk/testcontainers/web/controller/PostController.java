package com.artemnizhnyk.testcontainers.web.controller;

import com.artemnizhnyk.testcontainers.model.Post;
import com.artemnizhnyk.testcontainers.service.PostService;
import com.artemnizhnyk.testcontainers.web.dto.PostDto;
import com.artemnizhnyk.testcontainers.web.mapper.PostMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
@RestController
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable long id) {
        Post post = postService.getById(id);
        return postMapper.toDto(post);
    }

    @GetMapping
    public List<PostDto> getAll() {
        List<Post> posts = postService.getAll();
        return postMapper.toDto(posts);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto create(@Valid @RequestBody PostDto dto) {
        Post post = postMapper.toEntity(dto);
        post = postService.create(post);
        return postMapper.toDto(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        postService.delete(id);
    }

}
