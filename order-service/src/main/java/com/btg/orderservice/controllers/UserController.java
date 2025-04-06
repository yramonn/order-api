package com.btg.orderservice.controllers;

import com.btg.orderservice.dtos.OrderResponseDto;
import com.btg.orderservice.dtos.UserOrderCountResponseDto;
import com.btg.orderservice.models.OrderModel;
import com.btg.orderservice.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
@Tag(name = "Usuário", description = "Gerencia consultas relacionadas aos usuários e seus pedidos")

public class UserController {

    Logger logger = LogManager.getLogger(UserController.class);

    final OrderService orderService;

    public UserController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{userId}/orders/count")
    @Operation(
            summary = "Total de pedidos por usuário",
            description = "Retorna a quantidade total de pedidos feitos por um usuário específico."
    )
    public ResponseEntity<UserOrderCountResponseDto> getOrderCountByUserId(@PathVariable Long userId) {
        UserOrderCountResponseDto userOrderCount = orderService.orderCountByUserId(userId);
        logger.info("Total Count: {}", userOrderCount);
        return ResponseEntity.ok(userOrderCount);
    }

    @GetMapping("/{userId}/orders")
    @Operation(
            summary = "Listar pedidos por usuário",
            description = "Retorna todos os pedidos realizados por um usuário, incluindo os itens de cada pedido."
    )
    public ResponseEntity<List<OrderResponseDto>> getAllOrdersByUserId(@PathVariable Long userId) {
        List<OrderResponseDto> orders = orderService.findOrderByUserId(userId);
        logger.info("Orders: {}", orders);
        return ResponseEntity.ok(orders);
    }

}
