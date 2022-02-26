package com.example.schoolmanagement.repository;



import com.example.schoolmanagement.entity.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends CrudRepository<Instructor, Integer> {
    Optional<Instructor> findInstructorByName(String name);
    void deleteByName(String name);

    @Query(nativeQuery = true, value = "SELECT HOUR_SALARY AS salary FROM VISITING_RESEARCHER " +
            "UNION SELECT FIXED_SALARY as SALARY FROM PERMANENT_INSTRUCTOR" +
            "ORDER BY SALARY DESC")
    List<Instructor> getThreeMostEarningInstructor();
}
