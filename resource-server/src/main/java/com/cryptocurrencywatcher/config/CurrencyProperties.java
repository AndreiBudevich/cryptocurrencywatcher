package com.cryptocurrencywatcher.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "currencies")
public class CurrencyProperties {

    private List<Currency> list;

    public List<Currency> getList() {
        return list;
    }

    public void setList(List<Currency> list) {
        this.list = list;
    }

    public static class Currency {
        private String id;
        private String symbol;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    }
}