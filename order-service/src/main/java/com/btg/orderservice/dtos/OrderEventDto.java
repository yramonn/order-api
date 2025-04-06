package com.btg.orderservice.dtos;

import com.btg.orderservice.models.ItemModel;
import com.btg.orderservice.models.OrderModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record OrderEventDto(
        @JsonProperty("codigoPedido") Long orderId,
        @JsonProperty("codigoCliente") Long userId,
        @JsonProperty("itens") List<ItemEventDto> itens
)
 {

     public OrderModel convertToOrderModel() {
         OrderModel order = new OrderModel();
         order.setOrderId(orderId);

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
