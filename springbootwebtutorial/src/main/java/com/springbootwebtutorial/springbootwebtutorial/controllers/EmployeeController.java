package com.springbootwebtutorial.springbootwebtutorial.controllers;

import com.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getSecretMessage()
//    {
//        return "This is my Secret Message";
//    }
    @GetMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId)
    {
        return new EmployeeDTO(employeeId,"Ajeet","ajeet@gmail.com",25, LocalDate.of(2025,1,12),true);
    }

    @GetMapping("/employee")
    public String getAllEmployees(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String sortBy)
    {
        return "Hi age "+age+" "+sortBy;
    }
}
