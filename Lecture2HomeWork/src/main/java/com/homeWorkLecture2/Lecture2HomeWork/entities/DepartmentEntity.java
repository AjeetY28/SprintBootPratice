package com.homeWorkLecture2.Lecture2HomeWork.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DepartmentEntity {

    @Id
    private Long id;
    private String title;
    private Boolean isActive;
    private LocalDate createdAt;


}
