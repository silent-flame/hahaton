package com.brotuny.proj.controller;

import com.brotuny.proj.service.PostService;
import com.brotuny.proj.data.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin
@Controller
@RequestMapping("/api/post")
public class PostController {


    @Autowired
    private PostService postService;

    @PostMapping
    @ResponseBody
    public Post create(@RequestBody Post post) {
        Post newPost = postService.createPost(post);
        return newPost;
    }

    @GetMapping
    @ResponseBody
    public Post[] getAll() {
        return  postService.getAll();
    }

    @GetMapping(path="/{id}")
    @ResponseBody
    public Post getById(@PathVariable("id")long id) {
        return  postService.findPostById(id);
    }

}

