package com.example.onboarding.services;

import com.example.onboarding.models.Employee;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVReaderService {
    public List<Employee> CSVReader() {
        // declare result list
        List<Employee> lst = new ArrayList<>();

        // declare CSV mapper jackson
        CsvSchema csvSchema = CsvSchema.builder()
                .addColumn("id")
                .addColumn("name")
                .addColumn("email")
                .addColumn("telegram")
                .build()
                .withHeader();
        CsvMapper csvMapper = new CsvMapper();

        // try with resource
        try(InputStream is = new FileInputStream("src/main/resources/static/data.csv");
            MappingIterator<Employee> iter = csvMapper.readerFor(Employee.class).with(csvSchema).readValues(is)) {
                while (iter.hasNext()) {
                    Employee employee = iter.next();
                    lst.add(employee);
                }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        }

        return lst;
    }
}
