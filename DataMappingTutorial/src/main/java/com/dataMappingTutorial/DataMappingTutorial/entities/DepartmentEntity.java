package com.dataMappingTutorial.DataMappingTutorial.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="departments")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToOne
    @JoinColumn(name = "department_manager")
    private EmployeeEntity manager;

    @OneToMany(mappedBy = "workerDepartment",fetch = FetchType.LAZY)
    private Set<EmployeeEntity> workers;

    @ManyToMany(mappedBy = "freelanceDepartments")
    private Set<EmployeeEntity> freelancers;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
