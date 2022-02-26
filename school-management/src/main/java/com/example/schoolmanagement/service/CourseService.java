package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Course;
import com.example.schoolmanagement.repository.CourseRepository;
import com.example.schoolmanagement.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course> {
    private final CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {

        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(int id) {

        return courseRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Course not found"));
    }

    @Override
    public Course save(Course course) {

        if(courseRepository.existsById(course.getId())){
            throw new EntityExistsException("Course already exists");
        }
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {

        return courseRepository.save(course);
    }

    @Override
    public void deleteById(int id) {
        if(!courseRepository.existsById(id)){
            throw new EntityExistsException("Course is not exist");
        }
        courseRepository.deleteById(id);
    }

    @Override
    public Course findByName(String name) {
        return courseRepository.findCourseByName(name);
    }

    public void deleteByName(String name){
        courseRepository.deleteByName(name);
    }



    @Override
    public void delete(Course course) {
        if(!courseRepository.existsById(course.getId())) {
            throw new EntityNotFoundException("Course not found");
        }
    }
}
