package com.example.pet_RestAPI.adapter.persistence;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EmployeeEntity extends PersonEntity {

    private String position;
    private boolean fullTime;
}
