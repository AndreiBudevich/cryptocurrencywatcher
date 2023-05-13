package com.cryptocurrencywatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class CryptoCurrencyWatcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoCurrencyWatcherApplication.class, args);
    }
}