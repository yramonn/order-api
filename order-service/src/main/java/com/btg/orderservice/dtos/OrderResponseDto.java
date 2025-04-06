package com.btg.orderservice.dtos;

import java.math.BigDecimal;
import java.util.List;

public record OrderResponseDto(
        Long orderId,
        Long userId,
        BigDecimal totalValue,
        List<ItemResponseDto> itens
) {}
