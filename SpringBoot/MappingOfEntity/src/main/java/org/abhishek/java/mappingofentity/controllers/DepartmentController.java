package org.abhishek.java.mappingofentity.controllers;
import org.abhishek.java.mappingofentity.entities.DepartmentEntity;
import org.abhishek.java.mappingofentity.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private  final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "{departmentId}")
    public DepartmentEntity getDepartmentById(@PathVariable Long departmentId){
         return  departmentService.getDepartmentById(departmentId);

    }
    @PostMapping
    public  DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity departmentEntity){
           return departmentService.createNewDepartment(departmentEntity);
    }

    @PutMapping(path = "/{departmentId}/manager/{employeeId}")
    public  DepartmentEntity assignManagerToDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId){
        return  departmentService.assignManagerToDepartment(departmentId,employeeId);
    }


    @PutMapping(path = "/{departmentId}/worker/{employeeId}")
    public DepartmentEntity assignWorkerToDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId){
        return  departmentService.assignWorkerToDepartment(departmentId,employeeId);
    }
    @GetMapping
    public List<DepartmentEntity> getAllDepartments(){
        return  departmentService.getAllDepartmentList();
    }

    @PutMapping(path = "/{departmentId}/freelancer/{employeeId}")
    public DepartmentEntity assignFreelancerToDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId){
        return  departmentService.assignFreelancerToDepartment(departmentId,employeeId);
    }

}
