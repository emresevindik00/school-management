package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Instructor;
import com.example.schoolmanagement.service.InstructorService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {
    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> getAll() {
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> findById(@PathVariable int id) {
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/instructors")
    public Instructor saveInstructor(@io.swagger.v3.oas.annotations.parameters.RequestBody Instructor instructor){
        return instructorService.save(instructor);
    }

    @PutMapping("/instructors")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorService.update(instructor);
    }

    @DeleteMapping("/instructors/{id}")
    public String deleteById(@PathVariable int id){
        instructorService.deleteById(id);
        return "instructor with"+id+"deleted";
    }

    @GetMapping("instructors/getThreeMostEarningInstructor")
    public ResponseEntity<List<Instructor>> getThreeMostEarningInstructor() {
        return new ResponseEntity<>(instructorService.getThreeMostEarningInstructor(),HttpStatus.OK);
    }
}
