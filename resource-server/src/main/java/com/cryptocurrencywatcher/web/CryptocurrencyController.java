package com.cryptocurrencywatcher.web;

import com.cryptocurrencywatcher.model.Cryptocurrency;
import com.cryptocurrencywatcher.service.сryptocurrency.CryptocurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = CryptocurrencyController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Rest controller by cryptocurrency", description = "Allows users to manipulate cryptocurrencies")
public class CryptocurrencyController {

    static final String REST_URL = "/api/cryptocurrencies";

    private final CryptocurrencyService cryptocurrencyService;

    public CryptocurrencyController(CryptocurrencyService cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;
    }

    @GetMapping(value = "/by-symbol")
    @Operation(description = "get cryptocurrency by symbol")
    public Cryptocurrency getBySymbol(@RequestParam String symbol) {
        log.info("get by symbol {}", symbol);
        return cryptocurrencyService.getBySymbol(symbol);
    }
}