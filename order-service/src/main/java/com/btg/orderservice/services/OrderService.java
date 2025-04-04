package com.btg.orderservice.services;

import com.btg.orderservice.models.OrderModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface OrderService {

    OrderModel save(OrderModel orderModel);
    BigDecimal getOrderTotalValue(UUID orderId);
    Integer orderCountByUserId(UUID userId);
    List<OrderModel> findOrderByUserId(UUID userId);
}
