package org.abhishek.java.mappingofentity.repositories;

import org.abhishek.java.mappingofentity.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {

}
