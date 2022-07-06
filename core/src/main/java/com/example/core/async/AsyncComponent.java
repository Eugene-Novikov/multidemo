package com.example.core.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncComponent {
    @Async
    public void print(String msg) {
        System.err.println("submitted task with msg: " + msg);
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.err.println(msg + Thread.currentThread().getName());
    }
}
