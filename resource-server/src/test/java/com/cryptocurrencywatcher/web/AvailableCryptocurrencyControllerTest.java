package com.cryptocurrencywatcher.web;

import com.cryptocurrencywatcher.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.cryptocurrencywatcher.data.AvailableCryptocurrencyTestData.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AvailableCryptocurrencyControllerTest extends AbstractControllerTest {

    private static final String REST_URL = AvailableCryptocurrencyController.REST_URL;

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(AVAILABLE_CRYPTOCURRENCY_MATCHER.contentJson(availableCryptocurrency1, availableCryptocurrency2, availableCryptocurrency3));
    }
}