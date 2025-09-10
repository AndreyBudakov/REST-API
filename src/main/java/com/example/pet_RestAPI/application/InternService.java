package com.example.pet_RestAPI.application;

import com.example.pet_RestAPI.adapter.persistence.InternEntity;
import com.example.pet_RestAPI.adapter.persistence.InternRepository;
import com.example.pet_RestAPI.adapter.rest.dto.InternDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InternService {

    private final InternRepository internRepository;

    public InternDto create(InternDto dto) {
        InternEntity entity = new InternEntity();
        entity.setName(dto.name());
        entity.setAge(dto.age());
        entity.setSalary(dto.salary());
        entity.setSpecialty(dto.specialty());
        entity.setInternshipDuration(dto.internshipDuration());
        entity.setMentor(dto.mentor());

        InternEntity saved = internRepository.save(entity);

        return new InternDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getSalary(),
                saved.getSpecialty(),
                saved.getInternshipDuration(),
                saved.getMentor()
        );
    }

    public List<InternDto> getAll() {
        return internRepository.findAll()
                .stream()
                .map(saved -> new InternDto(
                        saved.getId(),
                        saved.getName(),
                        saved.getAge(),
                        saved.getSalary(),
                        saved.getSpecialty(),
                        saved.getInternshipDuration(),
                        saved.getMentor()
                ))
                .toList();
    }

    public InternDto getById(UUID id) {
        InternEntity saved = internRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Intern not found: " + id));
        return new InternDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getSalary(),
                saved.getSpecialty(),
                saved.getInternshipDuration(),
                saved.getMentor()
        );
    }

    public InternDto update(UUID id, InternDto dto) {
        InternEntity entity = internRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Intern not found: " + id));

        entity.setName(dto.name());
        entity.setAge(dto.age());
        entity.setSalary(dto.salary());
        entity.setSpecialty(dto.specialty());
        entity.setInternshipDuration(dto.internshipDuration());
        entity.setMentor(dto.mentor());

        return toDto(internRepository.save(entity));
    }

    private InternDto toDto(InternEntity entity) {
        return new InternDto(
                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getSalary(),
                entity.getSpecialty(),
                entity.getInternshipDuration(),
                entity.getMentor()
        );
    }

    public void delete(UUID id) {
        internRepository.deleteById(id);
    }
}

