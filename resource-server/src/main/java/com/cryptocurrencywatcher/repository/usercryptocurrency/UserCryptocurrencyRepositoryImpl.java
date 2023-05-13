package com.cryptocurrencywatcher.repository.usercryptocurrency;

import com.cryptocurrencywatcher.model.UserCryptocurrency;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<UserCryptocurrency> getAllWithUserAndCryptocurrency() {
        return userCryptocurrencyCrudRepository.getAllWithUserAndCryptocurrency();
    }
}
