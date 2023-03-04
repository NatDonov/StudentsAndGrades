package com.jb.exam.clr;

import com.jb.exam.beans.Student;
import com.jb.exam.exceptions.SchoolSystemException;
import com.jb.exam.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@Order(2)
public class ServerTest implements CommandLineRunner {

    @Autowired
    private StudentServiceImpl studentService;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("███████╗███████╗██████╗ ██╗   ██╗███████╗██████╗     ████████╗███████╗███████╗████████╗██╗███╗   ██╗ ██████╗ \n" +
                "██╔════╝██╔════╝██╔══██╗██║   ██║██╔════╝██╔══██╗    ╚══██╔══╝██╔════╝██╔════╝╚══██╔══╝██║████╗  ██║██╔════╝ \n" +
                "███████╗█████╗  ██████╔╝██║   ██║█████╗  ██████╔╝       ██║   █████╗  ███████╗   ██║   ██║██╔██╗ ██║██║  ███╗\n" +
                "╚════██║██╔══╝  ██╔══██╗╚██╗ ██╔╝██╔══╝  ██╔══██╗       ██║   ██╔══╝  ╚════██║   ██║   ██║██║╚██╗██║██║   ██║\n" +
                "███████║███████╗██║  ██║ ╚████╔╝ ███████╗██║  ██║       ██║   ███████╗███████║   ██║   ██║██║ ╚████║╚██████╔╝\n" +
                "╚══════╝╚══════╝╚═╝  ╚═╝  ╚═══╝  ╚══════╝╚═╝  ╚═╝       ╚═╝   ╚══════╝╚══════╝   ╚═╝   ╚═╝╚═╝  ╚═══╝ ╚═════╝ \n" +
                "                                                                                                             ");
        System.out.println("------------ ADD STUDENT --------");
        studentService.addStudent(Student.builder().
                name("Mosh").
                birthday(Date.valueOf(LocalDate.now().minusYears(20))).
                isActive(true).
                build());

        studentService.getAllStudents().forEach(System.out::println);

        System.out.println("------------ DELETE STUDENT ID=2 --------");
        studentService.deleteStudent(2);
        studentService.getAllStudents().forEach(System.out::println);

        try {
            System.out.println("---- id not found----");
            studentService.deleteStudent(10);
        } catch (SchoolSystemException schoolSystemException) {
            System.out.println(schoolSystemException);
        }

        System.out.println("------------ GET ONE STUDENT BY ID=1 --------");
        System.out.println(studentService.getOneStudent(1));
        try {
            System.out.println("---- id not found----");
            studentService.deleteStudent(10);
        } catch (SchoolSystemException schoolSystemException) {
            System.out.println(schoolSystemException);
        }

        System.out.println("------------ GET ONE STUDENT BY NAME=LIN --------");
        studentService.getAllStudentsByName("Lin").forEach(System.out::println);

        System.out.println("------------- AVG BY STUDENT ID -----------");
        System.out.println(studentService.avgGradesByStudentId(1));


    }
}
