package com.cryptocurrencywatcher.service.availablecryptocurrency;

import com.cryptocurrencywatcher.config.AvailableCryptocurrencyConfig;
import com.cryptocurrencywatcher.model.AvailableCryptocurrency;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableCryptocurrencyServiceImpl implements AvailableCryptocurrencyService {

    private final AvailableCryptocurrencyConfig availableCryptocurrencyConfig;


    public AvailableCryptocurrencyServiceImpl(AvailableCryptocurrencyConfig availableCryptocurrencyConfig) {
        this.availableCryptocurrencyConfig = availableCryptocurrencyConfig;
    }

    @Override
    public List<AvailableCryptocurrency> getAvailableCryptocurrencies() {
        return availableCryptocurrencyConfig.getAvailableCryptocurrencies();
    }
}