package com.cryptocurrencywatcher.service.сryptocurrency;

import com.cryptocurrencywatcher.model.Cryptocurrency;

public interface CryptocurrencyService {

    Cryptocurrency getBySymbol(String symbol);
}
