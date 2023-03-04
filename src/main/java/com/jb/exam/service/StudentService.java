package com.jb.exam.service;

import com.jb.exam.beans.Student;
import com.jb.exam.exceptions.SchoolSystemException;

import java.util.List;

public interface StudentService {

    void addStudent(Student student);

    void deleteStudent(long studentId) throws SchoolSystemException;

    List<Student> getAllStudents();

    Student getOneStudent(long studentId) throws SchoolSystemException;

    List<Student> getAllStudentsByName(String name);

    double avgGradesByStudentId(long id);
}


