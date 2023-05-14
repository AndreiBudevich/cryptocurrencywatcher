package com.cryptocurrencywatcher.service.сryptocurrency;

import com.cryptocurrencywatcher.config.AvailableCryptocurrencyConfig;
import com.cryptocurrencywatcher.model.AvailableCryptocurrency;
import com.cryptocurrencywatcher.model.Cryptocurrency;
import com.cryptocurrencywatcher.model.UserCryptocurrency;
import com.cryptocurrencywatcher.repository.usercryptocurrency.UserCryptocurrencyRepository;
import com.cryptocurrencywatcher.repository.сryptocurrency.CryptocurrencyRepository;
import com.cryptocurrencywatcher.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.cryptocurrencywatcher.util.CryptocurrencyUtil.*;
import static com.cryptocurrencywatcher.util.validation.ValidationUtil.checkNotFoundWithStatus;
import static java.lang.String.format;

@Service
@Slf4j
public class CryptocurrencyServiceImpl implements CryptocurrencyService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final AvailableCryptocurrencyConfig availableCryptocurrencyConfig;
    private final CryptocurrencyRepository cryptocurrencyRepository;
    private final UserCryptocurrencyRepository userCryptocurrencyRepository;

    public CryptocurrencyServiceImpl(AvailableCryptocurrencyConfig availableCryptocurrencyConfig,
                                     CryptocurrencyRepository cryptocurrencyRepository,
                                     UserCryptocurrencyRepository userCryptocurrencyRepository) {
        this.availableCryptocurrencyConfig = availableCryptocurrencyConfig;
        this.cryptocurrencyRepository = cryptocurrencyRepository;
        this.userCryptocurrencyRepository = userCryptocurrencyRepository;
    }

    @Scheduled(fixedRate = 60_000)
    public void autoRunSaveOrUpdate() {
        List<AvailableCryptocurrency> availableCryptocurrencies = availableCryptocurrencyConfig.getAvailableCryptocurrencies();
        Map<String, List<UserCryptocurrency>> userCryptocurrencies = getAllUserCryptocurrencies(userCryptocurrencyRepository);
        availableCryptocurrencies.forEach(aCryptocurrency -> saveOrUpdate(aCryptocurrency, userCryptocurrencies));
    }

    private void saveOrUpdate(AvailableCryptocurrency availableCryptocurrency, Map<String, List<UserCryptocurrency>> userCryptocurrencies) {
        Cryptocurrency cryptocurrency = getFromExternalSource(availableCryptocurrency);
        assert cryptocurrency != null;

        Cryptocurrency saveCryptocurrency = saveOrUpdateDatabase(cryptocurrency);
        String currentSymbol = cryptocurrency.getSymbol();

        List<UserCryptocurrency> userCryptocurrenciesByCurrentSymbol = userCryptocurrencies.get(cryptocurrency.getSymbol());
        userCryptocurrenciesByCurrentSymbol.forEach(userCryptocurrency -> checkingPriceChanges(userCryptocurrency, saveCryptocurrency, currentSymbol));
    }

    private void checkingPriceChanges(UserCryptocurrency userCryptocurrency, Cryptocurrency cryptocurrency, String currentSymbol) {
        BigDecimal priceUser = userCryptocurrency.getPrice();
        BigDecimal currentPrice = cryptocurrency.getPriceUsd();

        BigDecimal percentage = calculationOfExcessPercentageAbs(priceUser, currentPrice);
        if (compareToPercentage(percentage)) {
            String name = userCryptocurrency.getUser().getName();
            log.warn(currentSymbol + " : " + name + " : " + percentage);
        }
    }

    private final String CRYPTOCURRENCY_URL = "https://api.coinlore.net/api/ticker/?id=%d";

    private Cryptocurrency getFromExternalSource(AvailableCryptocurrency availableCryptocurrency) {

        Integer id = availableCryptocurrency.getId();
        String url = format(CRYPTOCURRENCY_URL, id);
        String jsonString = restTemplate.getForObject(url, String.class);
        return checkAndGetCryptocurrencies(JsonUtil.readValues(jsonString, Cryptocurrency.class));
    }

    private Cryptocurrency saveOrUpdateDatabase(Cryptocurrency cryptocurrency) {
        log.info("save or update {}", cryptocurrency);
        return cryptocurrencyRepository.saveOrUpdate(cryptocurrency);
    }

    @Override
    public Cryptocurrency getBySymbol(String symbol) {
        return checkNotFoundWithStatus(cryptocurrencyRepository.getBySymbol(symbol).orElse(null));
    }
}