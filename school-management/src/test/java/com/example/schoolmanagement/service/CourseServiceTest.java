package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Course;
import com.example.schoolmanagement.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

    @InjectMocks
    private CourseService courseService;

    @Mock
    private CourseRepository mockCourseRepository;

    @Test
    public void testFindAll() {

    }

    @Test
    public void testFindById() {
    }

    @Test
    public void testSave() {
        Course expected = new Course();
        expected.setName("Course");

        when(mockCourseRepository.save(any())).thenReturn(expected);

        Course actual = this.courseService.save(expected);

        assertAll(
                () -> assertEquals(expected, actual)
        );
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testDeleteById() {
    }

    @Test
    public void testFindByName() {
        Course expected = new Course();
        expected.setName("Course");

        when(mockCourseRepository.findCourseByName("Course")).thenReturn(expected);

        Course actual = this.courseService.findByName(expected.getName());

        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteByName() {
    }

    @Test
    public void testDelete() {
    }
}