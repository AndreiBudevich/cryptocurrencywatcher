package com.cryptocurrencywatcher.web;

import com.cryptocurrencywatcher.model.AvailableCryptocurrency;
import com.cryptocurrencywatcher.service.availablecryptocurrency.AvailableCryptocurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = AvailableCryptocurrencyController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Rest controller by available cryptocurrency", description = "Allows users get operation available cryptocurrency")
public class AvailableCryptocurrencyController {

    static final String REST_URL = "/api/available-currencies";


    private final AvailableCryptocurrencyService availableCryptocurrencyService;

    public AvailableCryptocurrencyController(AvailableCryptocurrencyService availableCryptocurrencyService) {
        this.availableCryptocurrencyService = availableCryptocurrencyService;
    }


    @GetMapping
    @Operation(description = "get all available cryptocurrencies")
    public List<AvailableCryptocurrency> getAvailableCryptocurrencies() {
        log.info("get all available cryptocurrencies");
        return availableCryptocurrencyService.getAvailableCryptocurrencies();
    }
}