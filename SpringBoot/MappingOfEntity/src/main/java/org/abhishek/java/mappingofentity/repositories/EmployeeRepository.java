package org.abhishek.java.mappingofentity.repositories;

import org.abhishek.java.mappingofentity.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
