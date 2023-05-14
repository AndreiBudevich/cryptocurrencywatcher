package com.cryptocurrencywatcher.repository.user;

import com.cryptocurrencywatcher.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> getByName(String name);

    User save(User user);
}
