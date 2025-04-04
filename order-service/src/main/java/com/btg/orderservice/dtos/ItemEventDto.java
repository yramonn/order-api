package com.btg.orderservice.dtos;

import java.math.BigDecimal;

public record ItemEventDto(String product,
                           Integer quantity,
                           BigDecimal value) {
}
