package com.ajeet.prod_ready_features.prod_ready_features.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

}
