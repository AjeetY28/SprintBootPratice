package com.homeWorkLecture2.Lecture2HomeWork.controllers;


import com.homeWorkLecture2.Lecture2HomeWork.DTO.DepartmentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getSecretMessage()
//    {
//        return "This is my Secret Message";
//    }

    @GetMapping("/{departmentId}")
    public DepartmentDTO getDepartmentById(@PathVariable(name="departmentId") Long Id)
    {
        return new DepartmentDTO(Id,"SWEngineer",true, LocalDate.now());
    }


}
