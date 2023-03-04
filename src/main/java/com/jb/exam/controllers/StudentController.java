package com.jb.exam.controllers;

import com.jb.exam.beans.Student;
import com.jb.exam.exceptions.SchoolSystemException;
import com.jb.exam.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable long studentId) throws SchoolSystemException {
        studentService.deleteStudent(studentId);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student getOneStudent(@PathVariable long studentId) throws SchoolSystemException {
        return studentService.getOneStudent(studentId);
    }

    @GetMapping("/by/name")
    public List<Student> getAllStudentsByName(@RequestParam String name) {
        return studentService.getAllStudentsByName(name);
    }

    @GetMapping("/{id}/grades/avg")
    public double avgGradesByStudentId(@PathVariable long id) {
        return studentService.avgGradesByStudentId(id);
    }
}
