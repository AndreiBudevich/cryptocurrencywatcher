package com.cryptocurrencywatcher.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "user_cryptocurrency")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserCryptocurrency extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cryptocurrency_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Cryptocurrency cryptocurrency;
}
