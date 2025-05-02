package com.example.onboarding.controllers;

import com.example.onboarding.dtos.EmployeeDTO;
import com.example.onboarding.models.Employee;
import com.example.onboarding.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> create(@Validated @RequestBody EmployeeDTO employeeDTO) {
        Employee savedEmployee = employeeService.employeeCreate(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get_by_id(@PathVariable("id") Integer id) {
        Employee employee = employeeService.employeeGetById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
