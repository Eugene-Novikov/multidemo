package com.example.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DataJpaApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(DataJpaApplication.class, args);
    }
}
