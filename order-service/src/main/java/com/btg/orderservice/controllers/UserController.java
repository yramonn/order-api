package com.btg.orderservice.controllers;

import com.btg.orderservice.dtos.UserOrderCountDto;
import com.btg.orderservice.models.OrderModel;
import com.btg.orderservice.services.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    Logger logger = LogManager.getLogger(UserController.class);

    final OrderService orderService;

    public UserController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{userId}/orders/count")
    public ResponseEntity<UserOrderCountDto> getOrderCountByUserId(@PathVariable Long userId) {
        UserOrderCountDto userOrderCount = orderService.orderCountByUserId(userId);
        logger.info("Total Count: {}", userOrderCount);
        return ResponseEntity.ok(userOrderCount);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<OrderModel>> getAllOrdersByUserId(@PathVariable Long userId) {
        List<OrderModel> orders = orderService.findOrderByUserId(userId);
        logger.info("Orders: {}", orders);
        return ResponseEntity.ok(orders);
    }

}
