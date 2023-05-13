package com.cryptocurrencywatcher.repository.usercryptocurrency;

import com.cryptocurrencywatcher.model.UserCryptocurrency;

import java.util.List;

public interface UserCryptocurrencyRepository {

    UserCryptocurrency save(UserCryptocurrency userCryptocurrency);

    List<UserCryptocurrency> getAllWithUserAndCryptocurrency();
}
