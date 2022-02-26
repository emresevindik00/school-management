package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    void deleteByName(String name);
    Course findCourseByName(String name);
}
