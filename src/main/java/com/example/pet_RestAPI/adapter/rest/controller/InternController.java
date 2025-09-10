package com.example.pet_RestAPI.adapter.rest.controller;

import com.example.pet_RestAPI.adapter.rest.dto.InternDto;
import com.example.pet_RestAPI.application.InternService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/interns")
@RequiredArgsConstructor
public class InternController {

    private final InternService internService;

    @PostMapping
    public InternDto create(@RequestBody InternDto dto) {
        return internService.create(dto);
    }

    @GetMapping
    public List<InternDto> getAll() {
        return internService.getAll();
    }

    @GetMapping("/{id}")
    public InternDto getById(@PathVariable UUID id) {
        return internService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        internService.delete(id);
    }
}

