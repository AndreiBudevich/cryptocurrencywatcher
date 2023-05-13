package com.cryptocurrencywatcher.service.сryptocurrency;

import com.cryptocurrencywatcher.config.AvailableCryptocurrencyConfig;
import com.cryptocurrencywatcher.model.AvailableCryptocurrency;
import com.cryptocurrencywatcher.model.Cryptocurrency;
import com.cryptocurrencywatcher.repository.сryptocurrency.CryptocurrencyRepository;
import com.cryptocurrencywatcher.util.JsonUtil;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.lang.String.format;

@Service
@Slf4j
public class CryptocurrencyServiceImpl implements CryptocurrencyService {

    private final String CRYPTOCURRENCY_URL = "https://api.coinlore.net/api/ticker/?id=%d";
    private final RestTemplate restTemplate = new RestTemplate();
    private final AvailableCryptocurrencyConfig availableCryptocurrencyConfig;
    private final CryptocurrencyRepository cryptocurrencyRepository;


    public CryptocurrencyServiceImpl(AvailableCryptocurrencyConfig availableCryptocurrencyConfig,
                                     CryptocurrencyRepository cryptocurrencyRepository) {
        this.availableCryptocurrencyConfig = availableCryptocurrencyConfig;
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    @PostConstruct
    @Scheduled(fixedRate = 60_000)
    public void autoRunSaveOrUpdate() {
        List<AvailableCryptocurrency> availableCryptocurrencies = availableCryptocurrencyConfig.getAvailableCryptocurrencies();
        availableCryptocurrencies.forEach(this::saveOrUpdate);
    }

    private void saveOrUpdate(AvailableCryptocurrency availableCryptocurrency) {
        Cryptocurrency cryptocurrency = getFromExternalSource(availableCryptocurrency);
        assert cryptocurrency != null;
        saveOrUpdateDatabase(cryptocurrency);
    }

    private Cryptocurrency getFromExternalSource(AvailableCryptocurrency availableCryptocurrency) {

        Integer id = availableCryptocurrency.getId();

        String url = format(CRYPTOCURRENCY_URL, id);

        String jsonString = restTemplate.getForObject(url, String.class);

        Cryptocurrency[] cryptocurrencies = JsonUtil.readValues(jsonString, Cryptocurrency.class);

        if (cryptocurrencies != null && cryptocurrencies.length > 0) {
            return cryptocurrencies[0];
        } else {
            return null;
        }
    }

    private void saveOrUpdateDatabase(Cryptocurrency cryptocurrency) {
        cryptocurrencyRepository.save(cryptocurrency);
        log.info("update {}", cryptocurrency);
    }
}