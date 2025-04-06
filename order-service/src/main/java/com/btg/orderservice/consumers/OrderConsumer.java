package com.btg.orderservice.consumers;

import com.btg.orderservice.dtos.OrderEventDto;
import com.btg.orderservice.services.OrderService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    final OrderService orderService;

    public OrderConsumer(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${order.broker.queue.orderEventQueue.name}", durable = "true"),
            exchange = @Exchange(value = "${order.broker.exchange.orderEventExchange}",
                    type = ExchangeTypes.FANOUT, ignoreDeclarationExceptions = "true"))
    )
    public void listenUserEvent(@Payload OrderEventDto orderEventDto) {
        var orderModel = orderEventDto.convertToOrderModel();
        orderService.save(orderModel);
    }
}
