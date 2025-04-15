package com.example.onboarding.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTest {

    @Test
    @DisplayName("Employee Setter & Getter Test")
    void EmployeeSetGetTest() {
        Employee employee = new Employee();

        employee.setId(1);
        Assertions.assertEquals(1, employee.getId());

        employee.setEmail("aw@com");
        Assertions.assertEquals("aw@com", employee.getEmail());

        employee.setName("ant");
        Assertions.assertEquals("ant", employee.getName());

        employee.setTelegram("000012345678");
        Assertions.assertEquals("000012345678", employee.getTelegram());
    }

    @Test
    @DisplayName("Employee Construct with parameters")
    void EmployeeConstructorParameterTest() {
        Employee employee = new Employee(1, "ant", "aw@com", "000012345678");

        Assertions.assertEquals(1, employee.getId());
        Assertions.assertEquals("aw@com", employee.getEmail());
        Assertions.assertEquals("ant", employee.getName());
        Assertions.assertEquals("000012345678", employee.getTelegram());
    }

    @Test
    @DisplayName("Employee To String Output")
    void EmployeeToString() {
        Employee employee = new Employee(1, "ant", "aw@com", "000012345678");

        Assertions.assertEquals("1antaw@com000012345678", employee.toString());
    }
}
