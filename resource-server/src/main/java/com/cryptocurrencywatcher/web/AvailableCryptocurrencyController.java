package com.cryptocurrencywatcher.web;

import com.cryptocurrencywatcher.model.AvailableCryptocurrency;
import com.cryptocurrencywatcher.service.availablecryptocurrency.AvailableCryptocurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = AvailableCryptocurrencyController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AvailableCryptocurrencyController {

    static final String REST_URL = "/api/available-currencies";


    private final AvailableCryptocurrencyService availableCryptocurrencyService;

    public AvailableCryptocurrencyController(AvailableCryptocurrencyService availableCryptocurrencyService) {
        this.availableCryptocurrencyService = availableCryptocurrencyService;
    }


    @GetMapping
    public List<AvailableCryptocurrency> getAvailableCryptocurrencies() {
        log.info("get all available cryptocurrencies");
        return availableCryptocurrencyService.getAvailableCryptocurrencies();
    }
}