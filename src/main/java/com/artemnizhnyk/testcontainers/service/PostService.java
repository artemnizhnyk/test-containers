package com.artemnizhnyk.testcontainers.service;

import com.artemnizhnyk.testcontainers.model.Post;

import java.util.List;

public interface PostService {

    Post getById(long id);

    List<Post> getAll();

    Post create(Post post);

    void delete(long id);

}
