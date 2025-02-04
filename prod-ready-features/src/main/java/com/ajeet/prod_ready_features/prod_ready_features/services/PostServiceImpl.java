package com.ajeet.prod_ready_features.prod_ready_features.services;

import com.ajeet.prod_ready_features.prod_ready_features.dto.PostDTO;
import com.ajeet.prod_ready_features.prod_ready_features.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;


    @Override
    public List<PostDTO> getAllPosts() {
        return List.of();
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        return null;
    }
}
