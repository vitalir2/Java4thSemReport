package com.example.task13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Task13Application {

    @Value("${student.name}")
    private String name;

    @Value("${student.last_name}")
    private String lastName;

    @Value("${student.group}")
    private String group;

    public static void main(String[] args) {
        SpringApplication.run(Task13Application.class, args);
    }

    @PostConstruct
    void onPostConstruct() {
        String result = "Name: " +
                name +
                ", last name: " +
                lastName +
                ", group: " +
                group;
        System.out.println(result);
    }

}
