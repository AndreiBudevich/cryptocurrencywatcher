package com.cryptocurrencywatcher.repository.сryptocurrency;

import com.cryptocurrencywatcher.model.Cryptocurrency;

import java.util.Optional;

public interface CryptocurrencyRepository {
    Cryptocurrency save(Cryptocurrency cryptocurrency);

    Optional<Cryptocurrency> getBySymbol(String symbol);
}