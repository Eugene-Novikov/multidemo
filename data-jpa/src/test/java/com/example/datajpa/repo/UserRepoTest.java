package com.example.datajpa.repo;

import com.example.datajpa.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@DataJpaTest
class UserRepoTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    void test() {
        var user1 = new User("Ann", Instant.now().minus(2, ChronoUnit.DAYS));
        var user2 = new User("Bob", Instant.now().minus(1, ChronoUnit.DAYS));
        var user3 = new User("Clark", Instant.now());
        userRepo.saveAll(List.of(user1, user2, user3));

        Iterable<User> users = userRepo.findByLastLoginLessThan(Instant.parse("2022-06-27T00:00:00Z"));
//        Iterable<User> users = userRepo.findAll();
//        Iterable<User> users = userRepo.findCustom2();
        System.out.println(users);
    }
}
