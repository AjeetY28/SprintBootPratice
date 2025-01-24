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
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modalMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modalMapper) {
        this.departmentRepository = departmentRepository;
        this.modalMapper = modalMapper;
    }

    //Get department by id
    public DepartmentDTO getDepartmentById(Long id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElse(null);
        return modalMapper.map(departmentEntity, DepartmentDTO.class);
    }

    //Get all departments
    public List<DepartmentDTO> getAllDepartment() {
        List<DepartmentEntity> departmentEntities=departmentRepository.findAll();
        return departmentEntities.stream()
                .map(departmentEntity -> modalMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    //Create New Department
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity toSaveEntity=modalMapper.map(departmentDTO,DepartmentEntity.class);
        DepartmentEntity savedEntity=departmentRepository.save(toSaveEntity);
        return modalMapper.map(savedEntity,DepartmentDTO.class);
    }

    //Update Department by Id
    public DepartmentDTO updateDepartmentById(DepartmentDTO departmentDTO,Long id) {
        if(!departmentRepository.existsById(id)){return null;}
        DepartmentEntity departmentEntity=modalMapper.map(departmentDTO,DepartmentEntity.class);
        departmentEntity.setId(id);
        DepartmentEntity savedEntity=departmentRepository.save(departmentEntity);
        return modalMapper.map(savedEntity,DepartmentDTO.class);
    }
    //Delete Department by Id
    public String deleteDepartmentById(Long id) {
        if(!departmentRepository.existsById(id))
        {
            return "Id not exist";
        }
        departmentRepository.deleteById(id);
        return "Deleted";
    }

}
