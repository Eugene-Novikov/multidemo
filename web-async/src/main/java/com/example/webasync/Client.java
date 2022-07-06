package com.example.webasync;

import com.example.webasync.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class Client {

    @Autowired
    private WebClient webClient;

    public Mono<User> getUser() {
        return webClient.get().uri("/mock/user?delay=4000")
                .retrieve()
                .bodyToMono(User.class);
    }
}
