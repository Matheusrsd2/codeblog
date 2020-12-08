package com.spring.codeblog.controllers;

import com.spring.codeblog.models.Post;
import com.spring.codeblog.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    CodeblogService service;

    @RequestMapping(value="/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = service.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @RequestMapping(value="/posts/{id}", method=RequestMethod.GET)
    public ModelAndView getDetails(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("postDetail");
        Post post = service.findById(id);
        mv.addObject("postDetail", post);
        return mv;
    }

}
