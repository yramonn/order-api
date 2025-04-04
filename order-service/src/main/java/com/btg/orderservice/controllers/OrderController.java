package com.btg.orderservice.controllers;

import com.btg.orderservice.models.OrderModel;
import com.btg.orderservice.services.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/orders")
public class OrderController {

    Logger logger = LogManager.getLogger(OrderController.class);

    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/{orderId}/valor-total")
    public ResponseEntity<BigDecimal> getOrderTotalValue(@PathVariable UUID orderId) {
        BigDecimal totalValue = orderService.getOrderTotalValue(orderId);
        return ResponseEntity.ok(totalValue);
    }

    @GetMapping("/users/{userId}/all-orders")
    public ResponseEntity<Integer> getOrderCountByUserId(@PathVariable UUID userId) {
        Integer total = orderService.orderCountByUserId(userId);
        return ResponseEntity.ok(total);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<OrderModel>> getAllOrdersByUserId(@PathVariable UUID userId) {
        List<OrderModel> orders = orderService.findOrderByUserId(userId);
        return ResponseEntity.ok(orders);
    }

}
