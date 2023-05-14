package com.cryptocurrencywatcher.model;

import com.cryptocurrencywatcher.util.validation.NoHtml;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"name"},
                name = "name_idx")})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Column(name = "name")
    @NotBlank
    @Size(min = 2, max = 120)
    @NoHtml
    private String name;

    @Column(name = "registration_time")
    @NotNull
    private LocalDateTime registrationTime;

    public User(String name, LocalDateTime registrationTime) {
        this.name = name;
        this.registrationTime = registrationTime;
    }

    public User(Integer id, String name) {
        super(id);
        this.name = name;
    }
}