package com.btg.orderservice.controllers;

import com.btg.orderservice.dtos.TotalOrderValueResponseDto;
import com.btg.orderservice.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@Tag(name = "Pedido", description = "Gerencia operações relacionadas aos pedidos.")
public class OrderController {

    Logger logger = LogManager.getLogger(OrderController.class);

    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}/value")
    @Operation(
            summary = "Buscar valor total de um pedido",
            description = "Retorna o valor total de um pedido específico com base no orderId."
    )
    public ResponseEntity<TotalOrderValueResponseDto> getOrderTotalValue(@PathVariable Long orderId) {
        TotalOrderValueResponseDto orderTotalValue = orderService.getOrderTotalValue(orderId);
        logger.info("Total Value: {} ", orderTotalValue);
        return ResponseEntity.ok(orderTotalValue);
    }
}
