package com.btg.orderservice.controllers;

import com.btg.orderservice.services.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;



@RestController
@RequestMapping("/orders")
public class OrderController {

    Logger logger = LogManager.getLogger(OrderController.class);

    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}/value")
    public ResponseEntity<BigDecimal> getOrderTotalValue(@PathVariable Long orderId) {
        BigDecimal totalValue = orderService.getOrderTotalValue(orderId);
        logger.info("Total Value: {} ", totalValue);
        return ResponseEntity.ok(totalValue);
    }
}
