package com.cryptocurrencywatcher.repository.user;

import com.cryptocurrencywatcher.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserCrudRepository userCrudRepository;

    public UserRepositoryImpl(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @Override
    public User save(User user) {
        return userCrudRepository.save(user);
    }
}
