package com.cryptocurrencywatcher.service.user;

import com.cryptocurrencywatcher.model.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    User getByName(String name);
}