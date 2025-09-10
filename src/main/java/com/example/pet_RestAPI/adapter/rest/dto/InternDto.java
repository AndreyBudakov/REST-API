package com.example.pet_RestAPI.adapter.rest.dto;

import java.util.UUID;

public record InternDto(

        UUID id,
        String name,
        int age,
        double salary,
        String specialty,
        int internshipDuration,
        String mentor
) {}
