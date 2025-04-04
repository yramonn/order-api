package com.btg.orderservice.dtos;

import com.btg.orderservice.models.ItemModel;
import com.btg.orderservice.models.OrderModel;
import com.btg.orderservice.models.UserModel;

import java.util.List;
import java.util.UUID;

public record OrderEventDto(UUID orderId,
                            UUID userId,
                            List<ItemEventDto> itens) {

    public OrderModel convertToOrderModel(UserModel userModel) {
        OrderModel order = new OrderModel();
        order.setOrderId(orderId);
        order.setUserId(userModel);

        List<ItemModel> itensModel = itens.stream().map(item -> {
            ItemModel itemModel = new ItemModel();
            itemModel.setProduct(item.product());
            itemModel.setQuantity(item.quantity());
            itemModel.setValue(item.value());
            itemModel.setOrder(order); // important: link bidirectionally
            return itemModel;
        }).toList();

        order.setItens(itensModel);
        order.calculateTotalValue();
        userModel.countOrder();

        return order;
    }
}
