package org.abhishek.java.mappingofentity.services;

import org.abhishek.java.mappingofentity.entities.EmployeeEntity;
import org.abhishek.java.mappingofentity.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private  final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity getEmployeeById(Long id){
        return  employeeRepository.findById(id).orElse(null);
    }

    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }
}
