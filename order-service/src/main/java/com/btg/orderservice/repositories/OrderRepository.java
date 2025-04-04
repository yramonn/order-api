package com.btg.orderservice.repositories;

import com.btg.orderservice.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, UUID> {

    // a. Retornar o valor total do pedido
    @Query("SELECT p.valorTotal FROM Pedido p WHERE p.codigoPedido = :codigoPedido")
    BigDecimal getOrderTotalValue(@Param("codigoPedido") UUID codigoPedido);

    // b. Contar a quantidade de pedidos por cliente
    @Query("SELECT COUNT(p) FROM OrderModel p WHERE p.codigoCliente = :codigoCliente")
    Long orderCountByUserId(@Param("userId") UUID userId);

    // c. Listar pedidos realizados por um cliente
    List<OrderModel> findOrderByUserId(UUID userId);

}
