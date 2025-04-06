package com.btg.orderservice.services;

import com.btg.orderservice.dtos.OrderEventDto;
import com.btg.orderservice.models.OrderModel;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    OrderModel save(OrderModel orderModel);
    void processOrderEvent(OrderEventDto dto);
    BigDecimal getOrderTotalValue(Long orderId);
    Integer orderCountByUserId(Long userId);
    List<OrderModel> findOrderByUserId(Long userId);
}
