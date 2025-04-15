package com.example.onboarding.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CSVReaderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /csv - 200 OK")
    void csvReaderTest() throws Exception {
        mockMvc.perform(get("/csv"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(4))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("a"))
                .andExpect(jsonPath("$[0].email").value("a@com"))
                .andExpect(jsonPath("$[0].telegram").value("-"));
    }
}
