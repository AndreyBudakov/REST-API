package com.example.pet_RestAPI.adapter.rest.dto;

import java.util.UUID;

public record ManagerDto(

        UUID id,
        String name,
        int age,
        double salary,
        String specialty,
        int teamSize,
        String department
) {}
