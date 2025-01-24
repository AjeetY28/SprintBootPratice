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

   private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}")
    public DepartmentDTO getDepartmentById(@PathVariable(value = "departmentId") Long id) {
        return departmentService.getDepartmentById(id);
    }
    @GetMapping
    public List<DepartmentDTO> getAllDepartment()
    {
        return departmentService.getAllDepartment();
    }

    @PostMapping
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return departmentService.createDepartment(departmentDTO);
    }
    @PutMapping("/{departmentId}")
    public DepartmentDTO updateDepartment(@RequestBody DepartmentDTO departmentDTO,@PathVariable(value = "departmentId") Long id)
    {
        return departmentService.updateDepartmentById(departmentDTO ,id);
    }

    @DeleteMapping("/{departmentId}")
    public String deleteDepartmentById(@PathVariable(value = "departmentId") Long id) {
        return departmentService.deleteDepartmentById(id);
    }
}
