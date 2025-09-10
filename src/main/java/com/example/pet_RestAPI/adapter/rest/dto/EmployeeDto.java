package com.example.pet_RestAPI.adapter.rest.dto;

import java.util.UUID;

public record EmployeeDto(

        UUID id,
        String name,
        int age,
        double salary,
        String specialty,
        String position,
        boolean fullTime
) {}
