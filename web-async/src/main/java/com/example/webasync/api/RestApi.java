package com.example.webasync.api;

import com.example.webasync.Client;
import com.example.webasync.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/async")
public class RestApi {

    @Autowired
    private Client client;

    @GetMapping("/user")
    public Mono<User> getUser() {
        log.info("receive request in controller");
        Mono<User> user = client.getUser();
        log.info("after request to another api");
        return user;
    }
}
