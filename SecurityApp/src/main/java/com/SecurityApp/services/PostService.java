package com.SecurityApp.services;

import com.SecurityApp.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<PostDTO> getAllPosts();

    PostDTO getPostById(Long postId);

    PostDTO createNewPost(PostDTO postDTO);
}
