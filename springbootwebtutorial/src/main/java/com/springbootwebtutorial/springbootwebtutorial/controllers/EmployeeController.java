package com.springbootwebtutorial.springbootwebtutorial.controllers;

import com.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employee") //it is parent path applicable for all these
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getSecretMessage()
//    {
//        return "This is my Secret Message";
//    }
//    @GetMapping("/employee/{employeeId}")  //when not use RequestMapping
     @GetMapping("/{employeeId}") //using RequestMapping
//    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId)//when the both employeeId variable name same for mapping and here
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") Long id)//when the both employeeId variable not name same for mapping and here

    {
        return new EmployeeDTO(id,"Ajeet","ajeet@gmail.com",25, LocalDate.of(2025,1,12),true);
    }

//    @GetMapping("/employee")  //When Not using RequestMapping
    @GetMapping //When Using RequestMapping
//    public String getAllEmployees(@RequestParam(required = false) Integer age, //if variable name change
    public String getAllEmployees(@RequestParam(required = false,name="inputAge") Integer age, //inputAge will write on web Url
                                  @RequestParam(required = false) String sortBy)
    {
        return "Hi age "+age+" "+sortBy;
    }

    @PostMapping   //use when we're Creating the resource
//    public String createNewEmployee()
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee)
    {
        inputEmployee.setId(100L);
        return inputEmployee;  //in postman http://localhost:8080/employee  url use and write in body and JSON format {"name" :"Ram", "email" : "ram@gmail.com","age" :23  }
//        return "hello for post"; for line no 36 or 35
    }

    @PutMapping //when we're updating the hole  resource
    public String updateEmployeeId()
    {
        return "Hello from put";
    }
}
