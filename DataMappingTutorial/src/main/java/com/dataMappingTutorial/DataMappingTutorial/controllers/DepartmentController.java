package com.dataMappingTutorial.DataMappingTutorial.controllers;

import com.dataMappingTutorial.DataMappingTutorial.entities.DepartmentEntity;
import com.dataMappingTutorial.DataMappingTutorial.services.DepartmentService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/departments")
public class DepartmentController {


    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}")
    public DepartmentEntity getDepartmentById(@PathVariable Long departmentId) {

            return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity departmentEntity){
        return departmentService.createNewDepartment(departmentEntity);
    }

}
