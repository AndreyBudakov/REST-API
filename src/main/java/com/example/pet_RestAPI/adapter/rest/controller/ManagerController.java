package com.example.pet_RestAPI.adapter.rest.controller;

import com.example.pet_RestAPI.adapter.rest.dto.ManagerDto;
import com.example.pet_RestAPI.application.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping
    public ManagerDto create(@RequestBody ManagerDto dto) {
        return managerService.create(dto);
    }

    @GetMapping
    public List<ManagerDto> getAll() {
        return managerService.getAll();
    }

    @GetMapping("/{id}")
    public ManagerDto getById(@PathVariable UUID id) {
        return managerService.getById(id);
    }

    @PutMapping("/{id}")
    public ManagerDto update(@PathVariable UUID id, @RequestBody ManagerDto dto) {
        return managerService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        managerService.delete(id);
    }
}

