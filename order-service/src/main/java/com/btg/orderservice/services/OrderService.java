package com.btg.orderservice.services;

import com.btg.orderservice.dtos.OrderEventDto;
import com.btg.orderservice.dtos.OrderResponseDto;
import com.btg.orderservice.dtos.TotalOrderValueResponseDto;
import com.btg.orderservice.dtos.UserOrderCountResponseDto;
import com.btg.orderservice.models.OrderModel;

import java.util.List;

public interface OrderService {

    OrderModel save(OrderModel orderModel);
    void processOrderEvent(OrderEventDto dto);
    TotalOrderValueResponseDto getOrderTotalValue(Long orderId);
    UserOrderCountResponseDto orderCountByUserId(Long userId);
    List<OrderResponseDto> findOrderByUserId(Long userId);
}
