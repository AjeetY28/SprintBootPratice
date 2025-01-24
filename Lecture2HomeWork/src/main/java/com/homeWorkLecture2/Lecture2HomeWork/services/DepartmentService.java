package com.homeWorkLecture2.Lecture2HomeWork.services;

import com.homeWorkLecture2.Lecture2HomeWork.DTO.DepartmentDTO;
import com.homeWorkLecture2.Lecture2HomeWork.entities.DepartmentEntity;
import com.homeWorkLecture2.Lecture2HomeWork.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DepartmentService {
    public final DepartmentRepository departmentRepository;
    public final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository,ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper=modelMapper;
    }


    public DepartmentDTO getDepartmentById(Long id) {
       return departmentRepository.findById(id).map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class)).orElse(null);
    }


    public List<DepartmentDTO> getAllDepartment() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities.stream().map(departmentEntity -> modelMapper
                        .map(departmentEntity, DepartmentDTO.class))
                        .collect(Collectors.toList());
    }


    public DepartmentDTO createNewDepartment(DepartmentDTO inputDepartment) {
        DepartmentEntity toSaveEntity=modelMapper.map(inputDepartment,DepartmentEntity.class); //convert dto to entity
        DepartmentEntity savedDepartmentEntity=departmentRepository.save(toSaveEntity); //then save entity
        return modelMapper.map(savedDepartmentEntity,DepartmentDTO.class); //convert entity to dto
    }


    public DepartmentDTO updateDepartmentById(Long id, DepartmentDTO departmentDTO) {
        if(!departmentRepository.existsById(id)){
            return null;
        }
        DepartmentEntity departmentEntity=modelMapper.map(departmentDTO,DepartmentEntity.class);
        departmentEntity.setId(id);
        DepartmentEntity savedDepartmentEntity=departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartmentEntity,DepartmentDTO.class);
    }

    public boolean deleteDepartmentById(Long id) {
        if(!departmentRepository.existsById(id)){
            return false;
        }
        departmentRepository.deleteById(id);
        return true;
    }
}
