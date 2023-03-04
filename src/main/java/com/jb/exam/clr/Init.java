package com.jb.exam.clr;

import com.jb.exam.beans.Grade;
import com.jb.exam.beans.Student;
import com.jb.exam.beans.Topic;
import com.jb.exam.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
@Order(1)
public class Init implements CommandLineRunner {


    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void run(String... args) throws Exception {


        Grade g1 = Grade.builder().score(50).topic(Topic.PROJECT1).build();
        Grade g2 = Grade.builder().score(20).topic(Topic.PROJECT2).build();
        Grade g3 = Grade.builder().score(70).topic(Topic.PROJECT3).build();
        Grade g4 = Grade.builder().score(80).topic(Topic.PROJECT3).build();
        Grade g5 = Grade.builder().score(80).topic(Topic.PROJECT3).build();

        Student s1 = Student.builder().
                name("Nat").
                birthday(Date.valueOf(LocalDate.now().minusYears(32))).
                grades(List.of(g1, g4)).
                isActive(true).
                build();
        g1.setStudent(s1);
        g4.setStudent(s1);

        Student s2 = Student.builder().
                name("Dan").
                birthday(Date.valueOf(LocalDate.now().minusYears(28))).
                grades(List.of(g2, g5)).
                isActive(false).
                build();
        g2.setStudent(s2);
        g5.setStudent(s2);

        Student s3 = Student.builder().
                name("Lin").
                birthday(Date.valueOf(LocalDate.now().minusYears(40))).
                grade(g3).
                isActive(false).
                build();
        g3.setStudent(s3);


        studentRepository.saveAll(List.of(s1, s2, s3));

        studentRepository.findAll().forEach(System.out::println);


    }
}
