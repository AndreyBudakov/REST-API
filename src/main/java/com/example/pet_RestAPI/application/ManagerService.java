package com.example.pet_RestAPI.application;

import com.example.pet_RestAPI.adapter.persistence.ManagerEntity;
import com.example.pet_RestAPI.adapter.persistence.ManagerRepository;
import com.example.pet_RestAPI.adapter.rest.dto.ManagerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerDto create(ManagerDto dto) {
        ManagerEntity entity = new ManagerEntity();
        entity.setName(dto.name());
        entity.setAge(dto.age());
        entity.setSalary(dto.salary());
        entity.setSpecialty(dto.specialty());
        entity.setTeamSize(dto.teamSize());
        entity.setDepartment(dto.department());

        ManagerEntity saved = managerRepository.save(entity);

        return new ManagerDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getSalary(),
                saved.getSpecialty(),
                saved.getTeamSize(),
                saved.getDepartment()
        );
    }

    public List<ManagerDto> getAll() {
        return managerRepository.findAll()
                .stream()
                .map(saved -> new ManagerDto(
                        saved.getId(),
                        saved.getName(),
                        saved.getAge(),
                        saved.getSalary(),
                        saved.getSpecialty(),
                        saved.getTeamSize(),
                        saved.getDepartment()
                ))
                .toList();
    }

    public ManagerDto getById(UUID id) {
        ManagerEntity saved = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found: " + id));
        return new ManagerDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getSalary(),
                saved.getSpecialty(),
                saved.getTeamSize(),
                saved.getDepartment()
        );
    }

    public ManagerDto update(UUID id, ManagerDto dto) {
        ManagerEntity entity = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found: " + id));

        entity.setName(dto.name());
        entity.setAge(dto.age());
        entity.setSalary(dto.salary());
        entity.setSpecialty(dto.specialty());
        entity.setTeamSize(dto.teamSize());
        entity.setDepartment(dto.department());

        return toDto(managerRepository.save(entity));
    }

    private ManagerDto toDto(ManagerEntity entity) {
        return new ManagerDto(
                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getSalary(),
                entity.getSpecialty(),
                entity.getTeamSize(),
                entity.getDepartment()
        );
    }

    public void delete(UUID id) {
        managerRepository.deleteById(id);
    }
}

