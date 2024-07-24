package org.abhishek.java.mappingofentity.services;

import org.abhishek.java.mappingofentity.entities.DepartmentEntity;
import org.abhishek.java.mappingofentity.entities.EmployeeEntity;
import org.abhishek.java.mappingofentity.repositories.DepartmentRepository;
import org.abhishek.java.mappingofentity.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);

    }

    public DepartmentEntity assignManagerToDepartment(Long departmentId, Long employeeId) {
        // first go to desired department
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);

        // get employee

        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        return departmentEntity.flatMap(department -> employeeEntity.map(employee -> {
            department.setManager(employee);
            // this will save in java object not in actual db
            return departmentRepository.save(department);
        })).orElse(null);


    }

    public DepartmentEntity assignWorkerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        return departmentEntity.flatMap(department ->
                employeeEntity.map(employee -> {
                    employee.setWorkerDepartment(department);
                    employeeRepository.save(employee);

                    department.getWorkers().add(employee);
                    return department;
                })).orElse(null);


    }

    public List<DepartmentEntity> getAllDepartmentList() {
         return departmentRepository.findAll();
    }

    public DepartmentEntity assignFreelancerToDepartment(Long departmentId, Long employeeId) {

        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

            return  departmentEntity.flatMap(department ->
                    employeeEntity.map(employee->{
                           employee.getFreelanceDepartment().add(department);
                           employeeRepository.save(employee);

                           return  department;
                            }
                            )).orElse(null);
    }
}