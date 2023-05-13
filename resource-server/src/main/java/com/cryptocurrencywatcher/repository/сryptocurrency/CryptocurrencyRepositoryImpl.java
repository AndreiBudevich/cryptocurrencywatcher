package com.cryptocurrencywatcher.repository.сryptocurrency;

import com.cryptocurrencywatcher.model.Cryptocurrency;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CryptocurrencyRepositoryImpl implements CryptocurrencyRepository {

    private final CryptocurrencyCrudRepository cryptocurrencyCrudRepository;

    public CryptocurrencyRepositoryImpl(CryptocurrencyCrudRepository cryptocurrencyCrudRepository) {
        this.cryptocurrencyCrudRepository = cryptocurrencyCrudRepository;
    }

    @Override
    public Cryptocurrency save(Cryptocurrency cryptocurrency) {
        return cryptocurrencyCrudRepository.save(cryptocurrency);
    }

    @Override
    public Optional<Cryptocurrency> getBySymbol(String symbol) {
        return cryptocurrencyCrudRepository.getBySymbol(symbol);
    }
}
