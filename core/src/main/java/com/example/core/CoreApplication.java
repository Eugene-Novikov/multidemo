package com.example.core;


import com.example.core.async.BootComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CoreApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(CoreApplication.class, args);

        var boot = context.getBean(BootComponent.class);
        boot.boot();
    }
}
