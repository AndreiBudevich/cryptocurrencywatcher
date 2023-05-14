package com.cryptocurrencywatcher.data;


import com.cryptocurrencywatcher.MatcherFactory;
import com.cryptocurrencywatcher.model.AvailableCryptocurrency;

public class AvailableCryptocurrencyTestData {
    public static final int AVAILABLE_CRYPTOCURRENCY_ID_1 = 90;
    public static final int AVAILABLE_CRYPTOCURRENCY_ID_2 = 80;
    public static final int AVAILABLE_CRYPTOCURRENCY_ID_3 = 48543;
    public static final MatcherFactory.Matcher<AvailableCryptocurrency> AVAILABLE_CRYPTOCURRENCY_MATCHER =
            MatcherFactory.usingIgnoringFieldsComparator(AvailableCryptocurrency.class, "");
    public static final AvailableCryptocurrency availableCryptocurrency1 = new AvailableCryptocurrency(AVAILABLE_CRYPTOCURRENCY_ID_1, "BTC");
    public static final AvailableCryptocurrency availableCryptocurrency2 = new AvailableCryptocurrency(AVAILABLE_CRYPTOCURRENCY_ID_2, "ETH");
    public static final AvailableCryptocurrency availableCryptocurrency3 = new AvailableCryptocurrency(AVAILABLE_CRYPTOCURRENCY_ID_3, "SOL");
}