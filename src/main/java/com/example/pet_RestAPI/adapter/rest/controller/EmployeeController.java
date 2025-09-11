package com.example.pet_RestAPI.adapter.rest.controller;

import com.example.pet_RestAPI.adapter.rest.dto.EmployeeDto;
import com.example.pet_RestAPI.application.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@Tag(name = "Employee Controller", description = "Управление сотрудниками")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(summary = "Создать сотрудника", description = "Создаёт нового сотрудника в системе")
    @PostMapping
    public EmployeeDto create(@RequestBody EmployeeDto dto) {
        return employeeService.create(dto);
    }

    @Operation(summary = "Получить всех сотрудников", description = "Возвращает список всех сотрудников")
    @GetMapping
    public List<EmployeeDto> getAll() {
        return employeeService.findAll();
    }

    @Operation(summary = "Обновить данные сотрудника", description = "Обновляет информацию по ID сотрудника")
    @PutMapping("/{id}")
    public EmployeeDto update(
            @PathVariable UUID id,
            @RequestBody EmployeeDto dto) {
        return employeeService.update(id, dto);
    }

    @Operation(summary = "Удалить сотрудника", description = "Удаляет сотрудника по ID")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        employeeService.delete(id);
    }
}