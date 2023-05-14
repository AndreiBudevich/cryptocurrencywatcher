package com.cryptocurrencywatcher.web;

import com.cryptocurrencywatcher.AbstractControllerTest;
import com.cryptocurrencywatcher.data.UserTestData;
import com.cryptocurrencywatcher.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.cryptocurrencywatcher.data.UserTestData.USER_MATCHER;

class UserControllerTest extends AbstractControllerTest {

    private static final String REST_URL = UserController.REST_URL;

    @Test
    void createWithLocation() throws Exception {
        User newUser = UserTestData.getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL + "/register")
                .param("name", "VASILUCHEK ALEKSANDR")
                .param("symbol", "BTC")
                .param("price", "20.20"));

        User created = USER_MATCHER.readFromJson(action);
        int newId = created.id();
        newUser.setId(newId);
        USER_MATCHER.assertMatch(created, newUser);
    }
}