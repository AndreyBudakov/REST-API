package com.example.pet_RestAPI.adapter.persistence;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ManagerEntity extends PersonEntity {

    private int teamSize;
    private String department;
}
