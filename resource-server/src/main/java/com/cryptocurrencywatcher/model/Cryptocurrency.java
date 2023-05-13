package com.cryptocurrencywatcher.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "cryptocurrency")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cryptocurrency extends BaseEntity {

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "name")
    private String name;

    @Column(name = "name_id")
    @JsonProperty("nameid")
    private String nameId;

    @Column(name = "rank")
    private Integer rank;

    @Column(name = "price_usd")
    @JsonProperty("price_usd")
    private BigDecimal priceUsd;

    @Column(name = "percent_change_24h")
    @JsonProperty("percent_change_24h")
    private BigDecimal percentChange24h;

    @Column(name = "percent_change_1h")
    @JsonProperty("percent_change_1h")
    private BigDecimal percentChange1h;

    @Column(name = "percent_change_7d")
    @JsonProperty("percent_change_7d")
    private BigDecimal percentChange7d;

    @Column(name = "market_cap_usd")
    @JsonProperty("market_cap_usd")
    private BigDecimal marketCapUsd;

    @Column(name = "volume24")
    private BigDecimal volume24;

    @Column(name = "volume24_native")
    @JsonProperty("volume24_native")
    private BigDecimal volume24Native;

    @Column(name = "c_supply")
    @JsonProperty("csupply")
    private BigDecimal cSupply;

    @Column(name = "price_btc")
    @JsonProperty("price_btc")
    private BigDecimal priceBtc;

    @Column(name = "t_supply")
    @JsonProperty("tsupply")
    BigDecimal tSupply;

    @Column(name = "m_supply")
    @JsonProperty("msupply")
    BigDecimal mSupply;
}