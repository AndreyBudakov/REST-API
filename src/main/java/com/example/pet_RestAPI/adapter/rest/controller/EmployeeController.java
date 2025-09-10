package com.example.pet_RestAPI.adapter.rest.controller;

import com.example.pet_RestAPI.adapter.rest.dto.EmployeeDto;
import com.example.pet_RestAPI.application.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeDto create(@RequestBody EmployeeDto dto) {
        return employeeService.create(dto);
    }

    @GetMapping
    public List<EmployeeDto> getAll() {
        return employeeService.findAll();
    }

    @PutMapping("/{id}")
    public EmployeeDto update(
            @PathVariable UUID id,
            @RequestBody EmployeeDto dto) {
        return employeeService.update(id, dto);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        employeeService.delete(id);
    }
}