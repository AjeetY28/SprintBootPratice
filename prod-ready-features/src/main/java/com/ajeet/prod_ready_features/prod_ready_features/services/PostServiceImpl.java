package com.ajeet.prod_ready_features.prod_ready_features.services;

import com.ajeet.prod_ready_features.prod_ready_features.dto.PostDTO;
import com.ajeet.prod_ready_features.prod_ready_features.entities.PostEntity;
import com.ajeet.prod_ready_features.prod_ready_features.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity,PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        postEntity = postRepository.save(postEntity);
        return modelMapper.map(postEntity, PostDTO.class);
    }
}
