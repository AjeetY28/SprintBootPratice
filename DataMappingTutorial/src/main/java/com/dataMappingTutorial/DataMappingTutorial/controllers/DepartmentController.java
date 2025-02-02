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

    @PutMapping(path = "/{departmentId}/manager/{employeeId}")
    public DepartmentEntity assignManagerToDepartment(@PathVariable Long departmentId,
                                                      @PathVariable Long employeeId) {
        return departmentService.assignManagerToDepartment(departmentId, employeeId);
    }

    @GetMapping(path = "/assignedDepartmentOfManager/{employeeId}")
    public DepartmentEntity getAssignedDepartmentOfManager(@PathVariable Long employeeId) {
        return departmentService.getAssignedDepartmentOfManager(employeeId);
    }

}
