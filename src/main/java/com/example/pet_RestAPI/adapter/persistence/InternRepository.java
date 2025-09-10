package com.example.pet_RestAPI.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InternRepository extends JpaRepository<InternEntity, UUID> {
}
