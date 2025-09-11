package com.example.pet_RestAPI.adapter.rest.controller;

import com.example.pet_RestAPI.adapter.rest.dto.ManagerDto;
import com.example.pet_RestAPI.application.ManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/managers")
@RequiredArgsConstructor
@Tag(name = "Менеджеры", description = "CRUD операции для менеджеров")
public class ManagerController {

    private final ManagerService managerService;

    @Operation(summary = "Создать менеджера", description = "Создаёт нового менеджера в системе")
    @PostMapping
    public ManagerDto create(@RequestBody ManagerDto dto) {
        return managerService.create(dto);
    }

    @Operation(summary = "Получить список менеджеров", description = "Возвращает список всех менеджеров")
    @GetMapping
    public List<ManagerDto> getAll() {
        return managerService.getAll();
    }

    @Operation(summary = "Получить менеджера по ID", description = "Возвращает менеджера по его уникальному идентификатору")
    @GetMapping("/{id}")
    public ManagerDto getById(
            @Parameter(description = "UUID менеджера", example = "c2c47e39-41cb-4d97-9aaf-4b15f37ebe1a")
            @PathVariable UUID id) {
        return managerService.getById(id);
    }

    @Operation(summary = "Обновить менеджера", description = "Обновляет данные менеджера по ID")
    @PutMapping("/{id}")
    public ManagerDto update(
            @Parameter(description = "UUID менеджера", example = "c2c47e39-41cb-4d97-9aaf-4b15f37ebe1a")
            @PathVariable UUID id,
            @RequestBody ManagerDto dto) {
        return managerService.update(id, dto);
    }

    @Operation(summary = "Удалить менеджера", description = "Удаляет менеджера по ID")
    @DeleteMapping("/delete/{id}")
    public void delete(
            @Parameter(description = "UUID менеджера", example = "c2c47e39-41cb-4d97-9aaf-4b15f37ebe1a")
            @PathVariable UUID id) {
        managerService.delete(id);
    }
}

