package com.btg.orderservice.dtos;

public record UserOrderCountResponseDto(Long userId,
                                        Integer totalCountOrders) {
}
