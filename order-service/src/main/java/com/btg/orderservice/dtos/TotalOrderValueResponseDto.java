package com.btg.orderservice.dtos;

import java.math.BigDecimal;

public record TotalOrderValueResponseDto(
        Long orderId,
        BigDecimal totalOrderValue
) {}
