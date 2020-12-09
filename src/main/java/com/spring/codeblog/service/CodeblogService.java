package com.spring.codeblog.service;

import com.spring.codeblog.models.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static sun.invoke.util.ValueConversions.cast;

@Service
public class CodeblogService implements ICodeblogService {

    @Autowired
    CodeblogRepository repository;

    @Override
    public List<Post> findAll() {

        return repository.findAll();
    }

    @Override
    public Post findById(long id) {

        return repository.findById(id).get();
    }

    @Override
    public void save(Post post) {

        repository.save(post);
    }
}
