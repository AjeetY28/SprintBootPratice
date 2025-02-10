package com.ajeet.prod_ready_features.prod_ready_features.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited//using to hibernate envers library to track the changes, an d it will create 2 mode table through which we can track the changes
public class PostEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
//    @NotAudited
    private String description;


    @PrePersist
    void beforeSave()
    {

    }

    @PreUpdate
    void beforeUpdate()
    {

    }

    @PreRemove
    void beforeDelete()
    {

    }
}
