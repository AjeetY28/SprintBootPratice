package com.homeWorkLecture2.Lecture2HomeWork.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long id;
    private String title;
    private Boolean isActive;
    private LocalDate createdAt;

}
