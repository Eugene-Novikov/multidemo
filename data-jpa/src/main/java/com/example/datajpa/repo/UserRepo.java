package com.example.datajpa.repo;

import com.example.datajpa.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;
import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findByLastLoginLessThan(Instant time);

    @Query(value = "select * from users where last_login is not null", nativeQuery = true)
    List<User> findCustom();

    @Query(value = "select u from User u")
    List<User> findCustom2();
}
