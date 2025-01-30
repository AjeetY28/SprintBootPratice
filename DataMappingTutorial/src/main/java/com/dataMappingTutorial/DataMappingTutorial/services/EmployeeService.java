package com.dataMappingTutorial.DataMappingTutorial.services;

import com.dataMappingTutorial.DataMappingTutorial.entities.EmployeeEntity;
import com.dataMappingTutorial.DataMappingTutorial.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
}
