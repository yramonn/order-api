package com.btg.orderservice.dtos;

import java.math.BigDecimal;

public record TotalOrderValueDto(
        Long orderId,
        BigDecimal totalOrderValue
) {}
