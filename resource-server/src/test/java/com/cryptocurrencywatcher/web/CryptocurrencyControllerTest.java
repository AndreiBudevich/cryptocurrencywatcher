package com.cryptocurrencywatcher.web;

import com.cryptocurrencywatcher.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.cryptocurrencywatcher.data.CryptocurrencyTestData.CRYPTOCURRENCY_MATCHER;
import static com.cryptocurrencywatcher.data.CryptocurrencyTestData.cryptocurrency1;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CryptocurrencyControllerTest extends AbstractControllerTest {

    private static final String REST_URL = CryptocurrencyController.REST_URL;

    @Test
    void getBySymbol() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "/by-symbol")
                .param("symbol", "BTC"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(CRYPTOCURRENCY_MATCHER.contentJson(cryptocurrency1));
    }

    @Test
    void getNotFound() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "/by-symbol")
                .param("symbol", "AND"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}