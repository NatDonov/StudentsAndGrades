package com.jb.exam.repos;

import com.jb.exam.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);


    @Query(value = "select avg(score) from grades where student_id = ?", nativeQuery = true)
    double avgGradesByStudentId(long studentId);
}
