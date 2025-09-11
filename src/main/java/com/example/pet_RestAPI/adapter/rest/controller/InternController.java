package com.example.pet_RestAPI.adapter.rest.controller;

import com.example.pet_RestAPI.adapter.rest.dto.InternDto;
import com.example.pet_RestAPI.application.InternService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/interns")
@RequiredArgsConstructor
@Tag(name = "Interns", description = "Управление стажёрами")
public class InternController {

    private final InternService internService;

    @Operation(summary = "Создать стажёра", description = "Создаёт нового стажёра в системе")
    @PostMapping
    public InternDto create(@RequestBody InternDto dto) {
        return internService.create(dto);
    }

    @Operation(summary = "Получить список всех стажёров", description = "Возвращает полный список стажёров")
    @GetMapping
    public List<InternDto> getAll() {
        return internService.getAll();
    }

    @Operation(summary = "Найти стажёра по ID", description = "Возвращает данные стажёра по его UUID")
    @GetMapping("/{id}")
    public InternDto getById(
            @Parameter(description = "UUID стажёра", example = "c2c47e39-41cb-4d97-9aaf-4b15f37ebe1a")
            @PathVariable UUID id) {
        return internService.getById(id);
    }

    @Operation(summary = "Обновить данные стажёра", description = "Изменяет данные стажёра по его UUID")
    @PutMapping("/{id}")
    public InternDto update(
            @Parameter(description = "UUID стажёра", example = "c2c47e39-41cb-4d97-9aaf-4b15f37ebe1a")
            @PathVariable UUID id,
            @RequestBody InternDto dto) {
        return internService.update(id, dto);
    }

    @Operation(summary = "Удалить стажёра", description = "Удаляет стажёра по UUID")
    @DeleteMapping("/delete/{id}")
    public void delete(
            @Parameter(description = "UUID стажёра", example = "c2c47e39-41cb-4d97-9aaf-4b15f37ebe1a")
            @PathVariable UUID id) {
        internService.delete(id);
    }
}

