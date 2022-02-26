package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Instructor;
import com.example.schoolmanagement.repository.InstructorRepository;
import com.example.schoolmanagement.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService implements BaseService<Instructor> {
    private final InstructorRepository instructorRepository;

    @Override
    public List<Instructor> findAll() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @Override
    public Instructor findById(int id) {
        return instructorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Instructor not found"));
    }

    @Override
    public Instructor save(Instructor instructor) {
        if(instructorRepository.existsById(instructor.getId())){
            throw new EntityExistsException("Instructor already exists");
        }
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        if(!instructorRepository.existsById(id)){
            throw new EntityNotFoundException("Course not exists");
        }
        instructorRepository.deleteById(id);
    }

    @Override
    public Instructor findByName(String name) {
        return instructorRepository.findInstructorByName(name).orElseThrow(() -> new EntityNotFoundException("Instructor not found"));
    }

    @Override
    public void deleteByName(String name) {
        if(instructorRepository.findInstructorByName(name).isEmpty()) {
            throw new EntityNotFoundException("Instructor not found!");
        }
        instructorRepository.deleteByName(name);
    }

    @Override
    public void delete(Instructor instructor) {
        if(!instructorRepository.existsById(instructor.getId())) {
            throw new EntityNotFoundException("Instructor not found!");
        }
        instructorRepository.delete(instructor);
    }

    public List<Instructor> getThreeMostEarningInstructor() {
        List<Instructor> list = instructorRepository.getThreeMostEarningInstructor();
        List<Instructor> getMostEarningInstructorByDesc = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            getMostEarningInstructorByDesc.add(list.get(i));
        }
        return getMostEarningInstructorByDesc;
    }
}
