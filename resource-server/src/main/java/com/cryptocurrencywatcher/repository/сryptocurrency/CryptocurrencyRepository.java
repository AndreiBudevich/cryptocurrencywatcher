package com.cryptocurrencywatcher.repository.сryptocurrency;

import com.cryptocurrencywatcher.model.Cryptocurrency;

public interface CryptocurrencyRepository {
    Cryptocurrency save(Cryptocurrency cryptocurrency);
}