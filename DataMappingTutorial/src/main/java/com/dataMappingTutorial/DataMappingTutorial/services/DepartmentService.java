package com.dataMappingTutorial.DataMappingTutorial.services;

import com.dataMappingTutorial.DataMappingTutorial.entities.DepartmentEntity;
import com.dataMappingTutorial.DataMappingTutorial.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;


@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity){
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }
}
