package com.cryptocurrencywatcher.model;

import com.cryptocurrencywatcher.util.validation.NoHtml;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "cryptocurrency", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"symbol"},
                name = "symbol_idx")})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cryptocurrency extends BaseEntity {

    @Column(name = "symbol")
    @NotBlank
    @Size(min = 2, max = 20)
    @NoHtml
    private String symbol;

    @Column(name = "name")
    @NoHtml
    private String name;

    @Column(name = "name_id")
    @JsonProperty("nameid")
    @NoHtml
    private String nameId;

    @Column(name = "rank")
    private Integer rank;

    @Column(name = "price_usd")
    @JsonProperty("price_usd")
    @NotNull
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

    public Cryptocurrency(Integer id, String symbol, String name, String nameId) {
        super(id);
        this.symbol = symbol;
        this.name = name;
        this.nameId = nameId;
    }
}