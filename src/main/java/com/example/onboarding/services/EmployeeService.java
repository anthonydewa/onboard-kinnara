package com.example.onboarding.services;

import com.example.onboarding.dtomappers.EmployeeMapper;
import com.example.onboarding.dtos.EmployeeDTO;
import com.example.onboarding.models.Employee;
import com.example.onboarding.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee employeeCreate(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.employeeCreateDTOToEmployee(employeeDTO);
        return employeeRepository.save(employee);
    }

    public Employee employeeGetByIdD(int id) {
        Optional<Employee> employeeRepo = employeeRepository.findById(id);

        if (employeeRepo.isPresent()) {
            return employeeRepo.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
        }
    }
}
