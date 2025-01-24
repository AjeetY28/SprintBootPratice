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
}
