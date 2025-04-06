package com.btg.orderservice.services;

import com.btg.orderservice.dtos.OrderEventDto;
import com.btg.orderservice.dtos.TotalOrderValueDto;
import com.btg.orderservice.dtos.UserOrderCountDto;
import com.btg.orderservice.models.OrderModel;

import java.util.List;

public interface OrderService {

    OrderModel save(OrderModel orderModel);
    void processOrderEvent(OrderEventDto dto);
    TotalOrderValueDto getOrderTotalValue(Long orderId);
    UserOrderCountDto orderCountByUserId(Long userId);
    List<OrderModel> findOrderByUserId(Long userId);
}
