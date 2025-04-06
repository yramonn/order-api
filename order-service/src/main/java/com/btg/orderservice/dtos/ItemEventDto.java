package com.btg.orderservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record ItemEventDto(
        @JsonProperty("produto") String product,
        @JsonProperty("quantidade") int quantity,
        @JsonProperty("preco") BigDecimal value
) {}
