package com.example.onboarding.services;

import com.example.onboarding.dtos.EmployeeDTO;
import com.example.onboarding.models.Employee;
import com.example.onboarding.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceTest {
    @MockitoBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Test
    @DisplayName(("Employee service create"))
    void employeeCreateServiceTest() {
        EmployeeDTO employeeDTO = new EmployeeDTO("ant", "ant@dew.com", "-");

        Employee employeeStub = new Employee(1, "ant", "ant@dew.com", "-");
        when(employeeRepository.save(any(Employee.class))).thenReturn(employeeStub);

        Employee savedEmployee = employeeService.employeeCreate(employeeDTO);

        Assertions.assertEquals(1, savedEmployee.getId());
        Assertions.assertEquals("ant", savedEmployee.getName());
        Assertions.assertEquals("ant@dew.com", savedEmployee.getEmail());
        Assertions.assertEquals("-", savedEmployee.getTelegram());
    }

    @Test
    @DisplayName(("Employee service get by ID"))
    void employeeGetByIDTest() {
        EmployeeDTO employeeDTO = new EmployeeDTO("ant", "ant@dew.com", "-");

        Employee employeeStub = new Employee(1, "ant", "ant@dew.com", "-");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employeeStub));

        Employee employee = employeeService.employeeGetByIdD(1);

        Assertions.assertEquals(1, employee.getId());
        Assertions.assertEquals("ant", employee.getName());
        Assertions.assertEquals("ant@dew.com", employee.getEmail());
        Assertions.assertEquals("-", employee.getTelegram());
    }

    @Test
    @DisplayName(("Employee service get by ID not found"))
    void employeeGetByIDNotFoundTest() {
        when(employeeRepository.findById(100)).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> { employeeService.employeeGetByIdD(100); });

        Assertions.assertEquals("Resource not found", exception.getReason());
        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
}
