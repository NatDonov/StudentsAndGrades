package com.jb.exam.service;

import com.jb.exam.beans.Student;
import com.jb.exam.exceptions.ErrMsg;
import com.jb.exam.exceptions.SchoolSystemException;
import com.jb.exam.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
        student.getGrades().forEach(t -> t.setStudent(student));
    }


    @Override
    public void deleteStudent(long studentId) throws SchoolSystemException {
        if (!studentRepository.existsById(studentId)) {
            throw new SchoolSystemException(ErrMsg.ID_NOT_FOUND);
        }

        studentRepository.deleteById(studentId);

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getOneStudent(long studentId) throws SchoolSystemException {
        return studentRepository.findById(studentId).orElseThrow(() -> new SchoolSystemException(ErrMsg.ID_NOT_FOUND));
    }

    @Override
    public List<Student> getAllStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public double avgGradesByStudentId(long id) {
        return studentRepository.avgGradesByStudentId(id);
    }
}
