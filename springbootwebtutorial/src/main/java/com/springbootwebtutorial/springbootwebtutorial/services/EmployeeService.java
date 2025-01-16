package com.springbootwebtutorial.springbootwebtutorial.services;


import com.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO getEmployeeById(Long id) {
      EmployeeEntity employeeEntity=  employeeRepository.findById(id).orElse(null);
      ModelMapper mapper=new ModelMapper();
      return mapper.map(employeeEntity, EmployeeDTO.class);

    }

    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity save(EmployeeEntity inputEmployee) {
        return employeeRepository.save(inputEmployee);
    }

}
