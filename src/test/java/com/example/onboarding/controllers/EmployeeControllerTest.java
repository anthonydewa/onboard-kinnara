package com.example.onboarding.controllers;

import com.example.onboarding.dtos.EmployeeDTO;
import com.example.onboarding.models.Employee;
import com.example.onboarding.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private EmployeeService employeeService;

    @Test
    @DisplayName("Test POST /employee return 201")
    void employeeCreateTest() throws Exception {
        EmployeeDTO employeeDTOStub = new EmployeeDTO("ant", "ant@dew.com", "-");
        String requestBody = objectMapper.writeValueAsString(employeeDTOStub);

        Employee employeeStub = new Employee(1, "ant", "ant@dew.com", "-");
        when(employeeService.employeeCreate(any(EmployeeDTO.class))).thenReturn(employeeStub);

        mockMvc.perform(post("/employee").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("ant"))
                .andExpect(jsonPath("$.email").value("ant@dew.com"))
                .andExpect(jsonPath("$.telegram").value("-"));
    }

    @Test
    @DisplayName("Test GET /employee return 201")
    void employeeGetByIDTest() throws Exception {
        Employee employeeStub = new Employee(1, "ant", "ant@dew.com", "-");
        when(employeeService.employeeGetById(1)).thenReturn(employeeStub);

        mockMvc.perform(get("/employee/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("ant"))
                .andExpect(jsonPath("$.email").value("ant@dew.com"))
                .andExpect(jsonPath("$.telegram").value("-"));
    }
}
