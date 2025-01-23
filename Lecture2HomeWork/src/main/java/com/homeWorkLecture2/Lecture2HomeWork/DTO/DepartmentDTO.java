package com.homeWorkLecture2.Lecture2HomeWork.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long id;
    private String title;
    private Boolean isActive;
    private LocalDate createdAt;

    public DepartmentDTO(Long id, String name, boolean isActive, LocalDate createdDate) {
        this.id = id;
        this.title = name;
        this.isActive = isActive;
        this.createdAt = createdDate;
    }
}
