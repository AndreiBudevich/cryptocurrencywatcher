package com.cryptocurrencywatcher.util;

import com.cryptocurrencywatcher.model.Cryptocurrency;
import com.cryptocurrencywatcher.model.UserCryptocurrency;
import com.cryptocurrencywatcher.repository.usercryptocurrency.UserCryptocurrencyRepository;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.math.RoundingMode.HALF_UP;

@UtilityClass
public class CryptocurrencyUtil {

    public static Map<String, List<UserCryptocurrency>> getAllUserCryptocurrencies(UserCryptocurrencyRepository userCryptocurrencyRepository) {
        return userCryptocurrencyRepository.getAllWithUserAndCryptocurrency().stream()
                .collect(Collectors.groupingBy(uc -> uc.getCryptocurrency().getSymbol()));
    }

    public static Boolean compareToPercentage(BigDecimal percentage) {
        return percentage.compareTo(BigDecimal.ONE) > 0;
    }

    private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

    public static BigDecimal calculationOfExcessPercentageAbs(BigDecimal dividend, BigDecimal divider) {
        return multiplyAndSubtractAndRounding100(dividend.divide(divider, 4, HALF_UP)).abs();
    }

    public Cryptocurrency checkAndGetCryptocurrencies(Cryptocurrency[] cryptocurrencies) {
        if (cryptocurrencies != null && cryptocurrencies.length > 0) {
            return cryptocurrencies[0];
        } else {
            return null;
        }
    }

    private static BigDecimal multiplyAndSubtractAndRounding100(BigDecimal multiplied) {
        return multiplied.multiply(ONE_HUNDRED).subtract(ONE_HUNDRED)
                .setScale(2, RoundingMode.HALF_UP);
    }
}