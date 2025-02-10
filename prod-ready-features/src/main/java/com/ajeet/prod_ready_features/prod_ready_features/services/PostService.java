package com.ajeet.prod_ready_features.prod_ready_features.services;


import com.ajeet.prod_ready_features.prod_ready_features.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO createNewPost(PostDTO inputPost);

    PostDTO gePostById(Long postId);

    PostDTO updatePost(PostDTO inputPost, Long postId);
}
