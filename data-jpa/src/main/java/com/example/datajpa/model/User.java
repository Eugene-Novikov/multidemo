package com.example.datajpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_pk_seq", allocationSize = 1)
    @GeneratedValue(generator = "user_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    @Column(name = "last_login")
    private Instant lastLogin;

    public User(String name, Instant lastLogin) {
        this.name = name;
        this.lastLogin = lastLogin;
    }
}
