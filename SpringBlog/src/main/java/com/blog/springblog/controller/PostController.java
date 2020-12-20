package com.blog.springblog.controller;

import com.blog.springblog.model.Post;
import com.blog.springblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("post/{id}")
    Post getPost(@PathVariable Long id)
    {
        return postService.getPostById(id);
    }

}
