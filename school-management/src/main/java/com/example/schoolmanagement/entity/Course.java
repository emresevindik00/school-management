package com.example.schoolmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String courseCode;
    private Float creditScore;

    @ManyToMany(mappedBy = "courseSet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Student> studentSet;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Instructor instructor;
}
