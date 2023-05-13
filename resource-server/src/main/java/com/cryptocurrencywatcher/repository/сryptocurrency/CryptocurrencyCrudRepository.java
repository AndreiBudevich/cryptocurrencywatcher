package com.cryptocurrencywatcher.repository.сryptocurrency;

import com.cryptocurrencywatcher.model.Cryptocurrency;
import com.cryptocurrencywatcher.repository.CommonCrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CryptocurrencyCrudRepository extends CommonCrudRepository<Cryptocurrency> {

    @Query("SELECT c FROM Cryptocurrency c WHERE c.symbol=?1")
    Optional<Cryptocurrency> getBySymbol(String symbol);
}