package com.example.onboarding.controllers;

import com.example.onboarding.models.Employee;
import com.example.onboarding.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get_by_id(@PathVariable("id") Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        return employee.map(value -> new ResponseEntity<>(value, HttpStatusCode.valueOf(200)))
                       .orElseGet(() -> new ResponseEntity<>(null, HttpStatusCode.valueOf(404)));
    }
}
