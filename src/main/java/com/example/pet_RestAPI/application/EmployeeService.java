package com.example.pet_RestAPI.application;

import com.example.pet_RestAPI.adapter.persistence.EmployeeEntity;
import com.example.pet_RestAPI.adapter.persistence.EmployeeRepository;
import com.example.pet_RestAPI.adapter.rest.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeDto create(EmployeeDto dto) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setName(dto.name());
        employee.setAge(dto.age());
        employee.setSalary(dto.salary());
        employee.setSpecialty(dto.specialty());
        employee.setPosition(dto.position());
        employee.setFullTime(dto.fullTime());

        EmployeeEntity saved = repository.save(employee);

        return mapToDto(saved);
    }

    public List<EmployeeDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public EmployeeDto update(UUID id, EmployeeDto dto) {
        EmployeeEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));

        entity.setName(dto.name());
        entity.setAge(dto.age());
        entity.setSalary(dto.salary());
        entity.setSpecialty(dto.specialty());
        entity.setPosition(dto.position());
        entity.setFullTime(dto.fullTime());

        return toDto(repository.save(entity));
    }

    private EmployeeDto toDto(EmployeeEntity entity) {
        return new EmployeeDto(
                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getSalary(),
                entity.getSpecialty(),
                entity.getPosition(),
                entity.isFullTime()
        );
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private EmployeeDto mapToDto(EmployeeEntity entity) {
        return new EmployeeDto(
                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getSalary(),
                entity.getSpecialty(),
                entity.getPosition(),
                entity.isFullTime()
        );
    }
}
