package com.cryptocurrencywatcher.service.user;

import com.cryptocurrencywatcher.model.User;
import com.cryptocurrencywatcher.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getByName(String name) {
        return userRepository.getByName(name).orElse(null);
    }
}