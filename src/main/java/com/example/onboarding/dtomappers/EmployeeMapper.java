package com.example.onboarding.dtomappers;

import com.example.onboarding.dtos.EmployeeDTO;
import com.example.onboarding.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee employeeCreateDTOToEmployee(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getName(), employeeDTO.getEmail(), employeeDTO.getTelegram());
    }
}
