package com.example.pet_RestAPI.adapter.persistence;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class InternEntity extends PersonEntity {

    private int internshipDuration;
    private String mentor;
}
