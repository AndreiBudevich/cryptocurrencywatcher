package com.cryptocurrencywatcher.config;

import com.cryptocurrencywatcher.model.AvailableCryptocurrency;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "available-cryptocurrency")

public class AvailableCryptocurrencyConfig {
    private List<AvailableCryptocurrency> availableCryptocurrencies;
}