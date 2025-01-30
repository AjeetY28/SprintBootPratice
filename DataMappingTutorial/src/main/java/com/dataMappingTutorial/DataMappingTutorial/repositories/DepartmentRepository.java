package com.dataMappingTutorial.DataMappingTutorial.repositories;

import com.dataMappingTutorial.DataMappingTutorial.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
