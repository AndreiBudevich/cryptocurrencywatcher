package com.cryptocurrencywatcher.model;

import com.cryptocurrencywatcher.util.validation.NoHtml;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AvailableCryptocurrency extends BaseEntity {

    @NotBlank
    @Size(min = 2, max = 20)
    @NoHtml
    private String symbol;

    public AvailableCryptocurrency(Integer id, String symbol) {
        super(id);
        this.symbol = symbol;
    }
}