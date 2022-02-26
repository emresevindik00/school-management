package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Student;
import com.example.schoolmanagement.exceptions.StudentAgeNotValidException;
import com.example.schoolmanagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService implements BaseService<Student>{

    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Student save(Student student) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int age = currentYear - student.getBirthDate().getYear();

        if(age < 18 || age > 45) {
            log.info("Student age should be between 18 and 40");
            throw new StudentAgeNotValidException("Student age should be between 18 and 40");
        }

        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Student findByName(String name) {
        return null;
    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void delete(Student student) {

    }
}
