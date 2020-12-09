package com.spring.codeblog.controllers;

import com.spring.codeblog.models.Post;
import com.spring.codeblog.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
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
        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping(value="/posts/new", method=RequestMethod.GET)
    public String getFormPost() {
        return "PostForm";
    }

    @RequestMapping(value="/posts/new", method=RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Todos os campos devem ser preenchidos");
            return "redirect:/posts/new";
        }
        post.setData(LocalDate.now());
        service.save(post);
        return "redirect:/posts";
    }



}
