package com.btg.orderservice.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    final CachingConnectionFactory cachingConnectionFactory;

    public RabbitmqConfig(CachingConnectionFactory cachingConnectionFactory) {
        this.cachingConnectionFactory = cachingConnectionFactory;
    }

    @Value("${order.broker.exchange.orderEventExchange}")
    private String orderEventExchange;

    @Value("${order.broker.queue.orderEventQueue.name}")
    private String orderEventQueue;

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(orderEventExchange);
    }

    @Bean
    public Queue orderQueue() {
        return new Queue(orderEventQueue, true);
    }

    @Bean
    public Binding bindingOrderQueueToExchange() {
        return BindingBuilder
                .bind(orderQueue())
                .to(fanoutExchange());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(cachingConnectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
