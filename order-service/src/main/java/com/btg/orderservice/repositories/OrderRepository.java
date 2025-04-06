package com.btg.orderservice.repositories;

import com.btg.orderservice.models.OrderModel;
import com.btg.orderservice.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, UUID> {

    //retornar o valor total do pedido
    @Query("SELECT p.totalValue FROM OrderModel p WHERE p.orderId = :codigoPedido")
    BigDecimal getOrderTotalValue(@Param("codigoPedido") UUID codigoPedido);

    //contar a quantidade de pedidos por cliente
    @Query("SELECT COUNT(p) FROM OrderModel p WHERE p.userId = :codigoCliente")
    Long orderCountByUserId(@Param("userId") UUID userId);

    //listar pedidos realizados por um cliente
    List<OrderModel> findByUserIdUserId(UUID userId);

}
