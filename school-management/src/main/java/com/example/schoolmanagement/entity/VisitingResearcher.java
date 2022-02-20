package com.example.schoolmanagement.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class VisitingResearcher extends Instructor{
    private Float hourSalary;
}
