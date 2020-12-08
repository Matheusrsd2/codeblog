package com.spring.codeblog.service;

import com.spring.codeblog.models.Post;

import java.util.List;

public interface ICodeblogService {

    List<Post> findAll ();

    Post findById (long id);

    void save (Post post);
}
