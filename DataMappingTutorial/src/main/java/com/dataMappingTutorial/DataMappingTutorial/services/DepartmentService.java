package com.dataMappingTutorial.DataMappingTutorial.services;

import com.dataMappingTutorial.DataMappingTutorial.entities.DepartmentEntity;
import com.dataMappingTutorial.DataMappingTutorial.entities.EmployeeEntity;
import com.dataMappingTutorial.DataMappingTutorial.repositories.DepartmentRepository;
import com.dataMappingTutorial.DataMappingTutorial.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;
    public DepartmentService(DepartmentRepository departmentRepository,EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository=employeeRepository;
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity){
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }

    public DepartmentEntity assignManagerToDepartment(Long departmentId, Long employeeId) {
       Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(departmentId);
       Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);

       return departmentEntity.flatMap(department ->
               employeeEntity.map(employee ->{
                   department.setManager(employee);
                   return departmentRepository.save(department);

               })).orElse(null);

    }
}
