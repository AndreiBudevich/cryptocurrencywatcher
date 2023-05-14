package com.cryptocurrencywatcher.web;

import com.cryptocurrencywatcher.model.Cryptocurrency;
import com.cryptocurrencywatcher.model.User;
import com.cryptocurrencywatcher.model.UserCryptocurrency;
import com.cryptocurrencywatcher.service.user.UserService;
import com.cryptocurrencywatcher.service.usercryptocurrency.UserCryptocurrencyService;
import com.cryptocurrencywatcher.service.сryptocurrency.CryptocurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;

import static com.cryptocurrencywatcher.util.DateTimeUtil.getCurrentDateTime;

@RestController
@Slf4j
@RequestMapping(value = UserController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Rest controller by user", description = "Allows users operations")
public class UserController {

    static final String REST_URL = "/api/users";

    private final UserService userService;
    private final CryptocurrencyService cryptocurrencyService;
    private final UserCryptocurrencyService userCryptocurrencyService;

    public UserController(UserService userService, UserCryptocurrencyService userCryptocurrencyService, CryptocurrencyService cryptocurrencyService) {
        this.userService = userService;
        this.userCryptocurrencyService = userCryptocurrencyService;
        this.cryptocurrencyService = cryptocurrencyService;
    }

    @PostMapping(value = "/register")
    @Operation(description = "registration user with need cryptocurrency")
    public ResponseEntity<User> createWithLocation(@RequestParam String name, @RequestParam String symbol, @RequestParam BigDecimal price) {

        User user = new User(name, getCurrentDateTime());
        User created = userService.save(user);
        assert created != null;
        Cryptocurrency cryptocurrency = cryptocurrencyService.getBySymbol(symbol);
        assert cryptocurrency != null;

        UserCryptocurrency userCryptocurrency = new UserCryptocurrency(user, price, getCurrentDateTime(), cryptocurrency);
        userCryptocurrencyService.save(userCryptocurrency);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        log.info("register {} by name {}", created, name);
        log.info("create user cryptocurrency by symbol {} by user name {} by price {}", symbol, name, price);
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}