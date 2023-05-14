package com.cryptocurrencywatcher.model;

import com.cryptocurrencywatcher.util.validation.NoHtml;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvailableCryptocurrency extends BaseEntity {

    @NotBlank
    @Size(min = 2, max = 20)
    @NoHtml
    private String symbol;
}