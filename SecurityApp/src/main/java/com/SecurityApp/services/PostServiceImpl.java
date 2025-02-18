package com.SecurityApp.services;

import com.SecurityApp.dto.PostDTO;
import com.SecurityApp.entities.PostEntity;
import com.SecurityApp.exceptions.ResourceNotFoundException;
import com.SecurityApp.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{


    private final ModelMapper modelMapper;
    private final PostRepository postRepository;


    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity,PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostById(Long postId) {
        PostEntity postEntity=postRepository
                .findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post not found"+postId));

        return modelMapper.map(postEntity,PostDTO.class);
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity=modelMapper.map(inputPost,PostEntity.class);

        return modelMapper.map(postRepository.save(postEntity), PostDTO.class);
    }
}
