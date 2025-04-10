package com.example.onboarding.controllers;

import com.example.onboarding.models.Employee;
import com.example.onboarding.services.CSVReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("csv")
public class CSVReaderController {
    @Autowired
    public CSVReaderService csvReaderService;

    @GetMapping("/csvreader")
    public ResponseEntity<List<Employee>> csvReader() {
        List<Employee> result = csvReaderService.CSVReader();

        return new ResponseEntity<>(result, HttpStatusCode.valueOf(200));
    }
}
