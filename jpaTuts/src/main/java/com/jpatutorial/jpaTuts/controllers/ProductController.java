package com.jpatutorial.jpaTuts.controllers;


import com.jpatutorial.jpaTuts.entities.ProductEntity;
import com.jpatutorial.jpaTuts.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path= "/products")
public class ProductController {

    private final int PAGE_SIZE=5;
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public Page<ProductEntity> getAllProducts(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "1")Integer pageNumber) {
//        return productRepository.findBy(Sort.by(Sort.Direction.DESC ,sortBy,"price"));
//        return productRepository.findBy(Sort.by(
//                Sort.Order.desc(sortBy),
//                Sort.Order.asc("title")
//        ));

        Pageable pageable= PageRequest.of(pageNumber,PAGE_SIZE);
        return productRepository.findAll(pageable);
    }
}
