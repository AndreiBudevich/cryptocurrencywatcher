package com.cryptocurrencywatcher.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "registration_time")
    private LocalDateTime registrationTime;

    public User(String name, LocalDateTime registrationTime) {
        this.name = name;
        this.registrationTime = registrationTime;
    }
}