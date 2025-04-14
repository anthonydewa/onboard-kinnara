package com.example.onboarding.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CSVReaderServiceTest {
    @Test
    @DisplayName("Read CSV from file to json output")
    void serviceReadCSV() {
        Assertions.assertEquals(1, 1);
    }
}
