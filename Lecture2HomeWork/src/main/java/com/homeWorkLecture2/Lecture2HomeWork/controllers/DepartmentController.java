package com.homeWorkLecture2.Lecture2HomeWork.controllers;


import com.homeWorkLecture2.Lecture2HomeWork.DTO.DepartmentDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
//@RequestMapping(path = "/department")
public class DepartmentController {



//    @GetMapping(path = "/getSecretMessage")
//    public String getSecretMessage()
//    {
//        return "This is my Secret Message";
//    }

    @GetMapping("/department/{departmentId}")
    public DepartmentDTO getDepartmentById(@PathVariable(name="departmentId") Long Id)
    {
        return new DepartmentDTO(Id,"SWEngineer",true, LocalDate.of(2025,1,1));

    }

}
