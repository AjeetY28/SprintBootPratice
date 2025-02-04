package com.ajeet.prod_ready_features.prod_ready_features.controllers;


import com.ajeet.prod_ready_features.prod_ready_features.dto.PostDTO;
import com.ajeet.prod_ready_features.prod_ready_features.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public PostDTO createNewPost(@RequestBody PostDTO inputPost) {
        return postService.createNewPost(inputPost);
    }
}
