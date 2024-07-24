package org.abhishek.java.springmvcw2.repository;

import org.abhishek.java.springmvcw2.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

     // this will all methods



}
