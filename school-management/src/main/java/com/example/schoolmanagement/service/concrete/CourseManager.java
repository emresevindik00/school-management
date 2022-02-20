package com.example.schoolmanagement.service.concrete;

import com.example.schoolmanagement.entity.Course;
import com.example.schoolmanagement.repository.CourseRepository;
import com.example.schoolmanagement.service.abstractt.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CourseManager implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseManager(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public List<Course> findAll() {

        return (List) courseRepository.findAll();
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
        return courseRepository.findCourseByName(name).orElseThrow(()-> new EntityNotFoundException("Course not found"));
    }

    public void deleteByName(String name){
        if(courseRepository.findCourseByName(name).isEmpty()){
            throw new EntityNotFoundException("Course not found");
        }
        courseRepository.deleteByName(name);
    }



    @Override
    public void delete(Course course) {
        if(!courseRepository.existsById(course.getId())) {
            throw new EntityNotFoundException("Course not found");
        }
    }
}