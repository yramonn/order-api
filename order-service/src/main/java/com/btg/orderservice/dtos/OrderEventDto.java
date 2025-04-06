package com.btg.orderservice.dtos;

import com.btg.orderservice.models.ItemModel;
import com.btg.orderservice.models.OrderModel;
import com.btg.orderservice.models.UserModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public record OrderEventDto(
        @JsonProperty("codigoPedido") UUID orderId,
        @JsonProperty("codigoCliente") UUID userId,
        @JsonProperty("itens") List<ItemEventDto> itens
)
 {

    public OrderModel convertToOrderModel() {
        OrderModel order = new OrderModel();
        order.setOrderId(orderId);

        UserModel userModel = new UserModel();
        userModel.setUserId(userId); // seta o ID que veio no DTO

        order.setUserId(userModel);

        List<ItemModel> itensModel = itens.stream().map(item -> {
            ItemModel itemModel = new ItemModel();
            itemModel.setProduct(item.product());
            itemModel.setQuantity(item.quantity());
            itemModel.setValue(item.value());
            itemModel.setOrder(order);
            return itemModel;
        }).toList();

        order.setItens(itensModel);
        order.calculateTotalValue();

        return order;
    }
}
