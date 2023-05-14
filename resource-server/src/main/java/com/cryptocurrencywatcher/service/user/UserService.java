package com.cryptocurrencywatcher.service.user;

import com.cryptocurrencywatcher.model.User;

public interface UserService {

    User save(User user);

    User getByName(String name);
}