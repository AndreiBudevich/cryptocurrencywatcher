package com.cryptocurrencywatcher.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvailableCryptocurrency extends BaseEntity {
    private String symbol;
}