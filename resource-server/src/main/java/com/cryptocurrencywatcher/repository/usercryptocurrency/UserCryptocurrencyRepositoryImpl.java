package com.cryptocurrencywatcher.repository.usercryptocurrency;

import com.cryptocurrencywatcher.model.UserCryptocurrency;
import org.springframework.stereotype.Repository;

@Repository
public class UserCryptocurrencyRepositoryImpl implements UserCryptocurrencyRepository {

    private final UserCryptocurrencyCrudRepository userCryptocurrencyCrudRepository;

    public UserCryptocurrencyRepositoryImpl(UserCryptocurrencyCrudRepository userCryptocurrencyCrudRepository) {
        this.userCryptocurrencyCrudRepository = userCryptocurrencyCrudRepository;
    }

    @Override
    public UserCryptocurrency save(UserCryptocurrency userCryptocurrency) {
        return userCryptocurrencyCrudRepository.save(userCryptocurrency);
    }
}
