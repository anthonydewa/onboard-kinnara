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

        Employee employee2 = new Employee("an", "aw@co", "0000123456789");

        Assertions.assertEquals(0, employee2.getId());
        Assertions.assertEquals("aw@co", employee2.getEmail());
        Assertions.assertEquals("an", employee2.getName());
        Assertions.assertEquals("0000123456789", employee2.getTelegram());
    }

    @Test
    @DisplayName("Employee To String Output")
    void EmployeeToString() {
        Employee employee = new Employee(1, "ant", "aw@com", "000012345678");

        Assertions.assertEquals("1antaw@com000012345678", employee.toString());
    }
}
