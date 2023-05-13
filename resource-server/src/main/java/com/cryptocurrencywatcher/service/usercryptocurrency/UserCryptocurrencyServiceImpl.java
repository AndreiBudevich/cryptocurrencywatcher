package com.cryptocurrencywatcher.service.usercryptocurrency;

import com.cryptocurrencywatcher.model.UserCryptocurrency;
import com.cryptocurrencywatcher.repository.usercryptocurrency.UserCryptocurrencyRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCryptocurrencyServiceImpl implements UserCryptocurrencyService {

    private final UserCryptocurrencyRepository userCryptocurrencyRepository;

    public UserCryptocurrencyServiceImpl(UserCryptocurrencyRepository userCryptocurrencyRepository) {
        this.userCryptocurrencyRepository = userCryptocurrencyRepository;
    }

    @Override
    public UserCryptocurrency save(UserCryptocurrency userCryptocurrency) {
        return userCryptocurrencyRepository.save(userCryptocurrency);
    }
}