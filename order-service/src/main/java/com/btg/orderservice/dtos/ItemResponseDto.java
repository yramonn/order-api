package com.btg.orderservice.dtos;


import java.math.BigDecimal;

public record ItemResponseDto(
        String product,
        Integer quantity,
        BigDecimal value
) {}
