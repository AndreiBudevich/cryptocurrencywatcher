package com.cryptocurrencywatcher.repository.user;

import com.cryptocurrencywatcher.model.User;
import com.cryptocurrencywatcher.repository.CommonCrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserCrudRepository extends CommonCrudRepository<User> {

    @Query("SELECT u FROM User u WHERE u.name=?1")
    Optional<User> getByName(String name);
}