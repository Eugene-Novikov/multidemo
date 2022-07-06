package com.example.core.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BootComponent {

    @Autowired
    private AsyncComponent asyncComponent;

    public void boot() {
        System.out.println("Run code in boot component: " + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            asyncComponent.print("Async task #" + i);
        }
        System.out.println("End execution of boot component: " + Thread.currentThread().getName());
    }
}
