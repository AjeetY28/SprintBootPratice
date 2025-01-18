package com.springbootwebtutorial.springbootwebtutorial.services;


import com.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository,ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper=modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
//      Optional<EmployeeEntity> employeeEntity=  employeeRepository.findById(id);
//      return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1,EmployeeDTO.class));

        return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class));

    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities=employeeRepository.findAll();
        return employeeEntities.stream().map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class)).
        collect(Collectors.toList());
    }
    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee)
    {
        EmployeeEntity toSaveEntity =modelMapper.map(inputEmployee,EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity=employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);
    }

    public EmployeeEntity save(EmployeeEntity inputEmployee) {
        return employeeRepository.save(inputEmployee);
    }

    public EmployeeDTO updateEmployeeById(Long employeeId,EmployeeDTO employeeDTO)
    {
        EmployeeEntity employeeEntity=modelMapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity=employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);
    }
    public boolean isExistsByEmployeeId(Long employeeId){
        return employeeRepository.existsById(employeeId);
    }
    public boolean deleteEmployeeById(Long employeeId)
    {
        boolean exits=isExistsByEmployeeId(employeeId);
        if(!exits) return false;
        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
        boolean exits=isExistsByEmployeeId(employeeId);
        if(!exits) return null;
        EmployeeEntity employeeEntity=employeeRepository.findById(employeeId).get();
        updates.forEach((filed,value)->{
            Field fieldToBeUpdated =ReflectionUtils.findRequiredField(EmployeeEntity.class,filed);
            fieldToBeUpdated.setAccessible(true);

            ReflectionUtils.setField(fieldToBeUpdated,employeeEntity,value);
        });
         return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);
    }
}
