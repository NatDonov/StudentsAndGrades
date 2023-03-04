package com.jb.exam.clr;

import com.jb.exam.beans.Grade;
import com.jb.exam.beans.Student;
import com.jb.exam.beans.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;


@Component
@Order(3)
public class StudentControllerTest implements CommandLineRunner {
    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://localhost:8080/api/student";


    @Override
    public void run(String... args) throws Exception {
        System.out.println(" ██████╗ ██████╗ ███╗   ██╗████████╗██████╗  ██████╗ ██╗     ██╗     ███████╗██████╗     ████████╗███████╗███████╗████████╗\n" +
                "██╔════╝██╔═══██╗████╗  ██║╚══██╔══╝██╔══██╗██╔═══██╗██║     ██║     ██╔════╝██╔══██╗    ╚══██╔══╝██╔════╝██╔════╝╚══██╔══╝\n" +
                "██║     ██║   ██║██╔██╗ ██║   ██║   ██████╔╝██║   ██║██║     ██║     █████╗  ██████╔╝       ██║   █████╗  ███████╗   ██║   \n" +
                "██║     ██║   ██║██║╚██╗██║   ██║   ██╔══██╗██║   ██║██║     ██║     ██╔══╝  ██╔══██╗       ██║   ██╔══╝  ╚════██║   ██║   \n" +
                "╚██████╗╚██████╔╝██║ ╚████║   ██║   ██║  ██║╚██████╔╝███████╗███████╗███████╗██║  ██║       ██║   ███████╗███████║   ██║   \n" +
                " ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚══════╝╚══════╝╚═╝  ╚═╝       ╚═╝   ╚══════╝╚══════╝   ╚═╝   \n" +
                "                                                                                                                           ");

        Grade g1 = Grade.builder().score(50).topic(Topic.PROJECT1).build();

        Student s1 = Student.builder().
                name("Mesi").
                birthday(Date.valueOf(LocalDate.now().minusYears(35))).
                isActive(true).
                grade(g1).
                build();

        System.out.println("------------ADD STUDENT---------------");
        ResponseEntity<String> res = restTemplate.postForEntity(url, s1, String.class);
        System.out.println(res.getStatusCode());

        System.out.println("-------------GET ALL STUDENTS BEFORE DELETE--------------");
        Arrays.asList(restTemplate.getForObject(url, Student[].class)).forEach(System.out::println);
        System.out.println("--------------DELETE STUDENT-------------");
        restTemplate.delete(url + "/3");
        System.out.println("-------------GET ALL STUDENTS AFTER DELETE--------------");
        Arrays.asList(restTemplate.getForObject(url, Student[].class)).forEach(System.out::println);


        System.out.println("-------------GET ONE STUDENT BY ID=1--------------");

        Student res1 = restTemplate.getForObject(url + "/1", Student.class);
        System.out.println(res1);

        System.out.println("-------------GET STUDENT BY NAME=Nat--------------");
        Arrays.asList(restTemplate.getForObject(url + "/by/name?name=nat", Student[].class)).forEach(System.out::println);

        System.out.println("-------------AVG BY STUDENT ID--------------");
        Double res3 = restTemplate.getForObject(url + "/1/grades/avg", Double.class);
        System.out.println(res3);


    }
}
