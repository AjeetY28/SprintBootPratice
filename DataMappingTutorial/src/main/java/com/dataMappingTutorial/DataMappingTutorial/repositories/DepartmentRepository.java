package com.dataMappingTutorial.DataMappingTutorial.repositories;

import com.dataMappingTutorial.DataMappingTutorial.entities.DepartmentEntity;
import com.dataMappingTutorial.DataMappingTutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
    DepartmentEntity findByManager(EmployeeEntity employeeEntity);
}
