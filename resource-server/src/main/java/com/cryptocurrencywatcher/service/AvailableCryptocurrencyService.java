package com.cryptocurrencywatcher.service;

import com.cryptocurrencywatcher.model.AvailableCryptocurrency;

import java.util.List;

public interface AvailableCryptocurrencyService {

    List<AvailableCryptocurrency> getAvailableCryptocurrencies();
}