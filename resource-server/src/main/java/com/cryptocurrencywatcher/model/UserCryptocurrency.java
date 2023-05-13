package com.cryptocurrencywatcher.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_cryptocurrency", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"user_id", "cryptocurrency_id"},
                name = "user_id_cryptocurrency_id_idx")})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserCryptocurrency extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "prise_time")
    private LocalDateTime priseTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cryptocurrency_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Cryptocurrency cryptocurrency;

    public UserCryptocurrency(User user, BigDecimal price, LocalDateTime priseTime, Cryptocurrency cryptocurrency) {
        this.user = user;
        this.price = price;
        this.priseTime = priseTime;
        this.cryptocurrency = cryptocurrency;
    }
}
