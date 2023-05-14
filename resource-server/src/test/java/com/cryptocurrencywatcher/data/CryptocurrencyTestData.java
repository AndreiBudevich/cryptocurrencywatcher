package com.cryptocurrencywatcher.data;

import com.cryptocurrencywatcher.MatcherFactory;
import com.cryptocurrencywatcher.model.Cryptocurrency;

public class CryptocurrencyTestData {
    public static final int CRYPTOCURRENCY_ID_1 = 90;

    public static final MatcherFactory.Matcher<Cryptocurrency> CRYPTOCURRENCY_MATCHER =
            MatcherFactory.usingIgnoringFieldsComparator(Cryptocurrency.class, "rank", "priceUsd", "percentChange24h",
                    "percentChange1h", "percentChange7d", "marketCapUsd", "volume24", "volume24Native", "cSupply", "price_btc",
                    "tSupply", "mSupply");

    public static final Cryptocurrency cryptocurrency1 = new Cryptocurrency(CRYPTOCURRENCY_ID_1, "BTC", "Bitcoin", "bitcoin");
}