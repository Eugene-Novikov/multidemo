package com.example.web.api;

import com.example.web.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mock")
public class MockRestApi {

    @GetMapping("/user")
    public User getUser(@RequestParam(required = false) Long delay) throws InterruptedException {
        log.info("request received");
        if (delay != null) {
            Thread.sleep(delay);
        }
        return new User(1L, "James");
    }
}
