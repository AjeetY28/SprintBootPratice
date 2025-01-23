package com.homeWorkLecture2.Lecture2HomeWork.repositories;

import com.homeWorkLecture2.Lecture2HomeWork.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {

}
