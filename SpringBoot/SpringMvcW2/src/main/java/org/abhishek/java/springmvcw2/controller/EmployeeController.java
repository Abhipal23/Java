package org.abhishek.java.springmvcw2.controller;

import jakarta.validation.Valid;
import org.abhishek.java.springmvcw2.dto.EmployeeDto;
import org.abhishek.java.springmvcw2.exceptions.ResourceNotFoundException;
import org.abhishek.java.springmvcw2.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeByID(@PathVariable(name = "employeeId") Long empId) {
        Optional<EmployeeDto> employeeDto = Optional.ofNullable(employeeService.getEmployeeById(empId));
        return employeeDto.map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with Id"+empId));
    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleException(NoSuchElementException e) {
//        return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
//    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmpDetails(@RequestParam(required = false) Integer age) {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        EmployeeDto savedData = employeeService.createNewEmployee(employeeDto);
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@RequestBody  @Valid EmployeeDto employeeDto, @PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.updateEmployyeById(employeeId, employeeDto));
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId) {
        boolean deleted = employeeService.deleteEmployeeById(employeeId);
        if (deleted) return ResponseEntity.ok(true);
        else return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDto> updatePartiallyEmployeeById(@RequestBody Map<String, Object> updates, @PathVariable Long employeeId) {
        EmployeeDto employeeDto = employeeService.partiallyUpdate(employeeId, updates);
        if (employeeDto == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(employeeDto);
    }
}
