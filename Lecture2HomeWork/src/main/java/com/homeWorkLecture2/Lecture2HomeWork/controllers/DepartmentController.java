package com.homeWorkLecture2.Lecture2HomeWork.controllers;


import com.homeWorkLecture2.Lecture2HomeWork.DTO.DepartmentDTO;
import com.homeWorkLecture2.Lecture2HomeWork.entities.DepartmentEntity;
import com.homeWorkLecture2.Lecture2HomeWork.repositories.DepartmentRepository;
import com.homeWorkLecture2.Lecture2HomeWork.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/{departmentId}")
    public DepartmentDTO getDepartmentById(@PathVariable(name="departmentId") Long id)
    {

        return departmentService.getDepartmentById(id);
    }
    @GetMapping
    public List<DepartmentDTO> getAllDepartments()
    {
        return departmentService.getAllDepartment();
    }

    @PostMapping
    public DepartmentDTO createNewDepartment(@RequestBody DepartmentDTO inputDepartment)
    {
         return departmentService.createNewDepartment(inputDepartment);
    }

    @PutMapping("/{departmentId}")
    public DepartmentDTO updateDepartmentById(@PathVariable(name="departmentId") Long id, @RequestBody DepartmentDTO departmentDTO){
        return departmentService.updateDepartmentById(id,departmentDTO);
    }


    @DeleteMapping("/{departmentId}")
    public boolean deleteDepartmentById(@PathVariable(name="departmentId") Long id,DepartmentDTO departmentDTO)
    {
        return departmentService.deleteDepartmentById(id);
    }

}
