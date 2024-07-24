package org.abhishek.java.mappingofentity.controllers;


import org.abhishek.java.mappingofentity.entities.DepartmentEntity;
import org.abhishek.java.mappingofentity.entities.EmployeeEntity;
import org.abhishek.java.mappingofentity.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

   private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployee(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public  EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.createNewEmployee(employeeEntity);
    }
    @GetMapping
    public List<EmployeeEntity> getAllDepartment() {
        return employeeService.findAll().stream().toList();
    }
}
