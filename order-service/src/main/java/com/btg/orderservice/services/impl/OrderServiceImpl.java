package com.btg.orderservice.services.impl;

import com.btg.orderservice.dtos.OrderEventDto;
import com.btg.orderservice.models.OrderModel;
import com.btg.orderservice.models.UserModel;
import com.btg.orderservice.repositories.OrderRepository;
import com.btg.orderservice.repositories.UserRepository;
import com.btg.orderservice.services.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    final OrderRepository orderRepository;
    final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public OrderModel save(OrderModel orderModel) {
         OrderModel newOrder = orderRepository.save(orderModel);
         logger.info("New order save with success: {}", newOrder);
         return orderModel;
    }

    @Override
    public void processOrderEvent(OrderEventDto dto) {
        Optional<UserModel> optionalUser = userRepository.findById(dto.userId());

        UserModel userModel = optionalUser.orElseGet(() -> {
            UserModel newUser = new UserModel();
            newUser.setUserId(dto.userId());
            return newUser;
        });

        userModel.countOrder();
        logger.info("User {} has {} orders now", userModel.getUserId(), userModel.getQuantityOrder());
        userRepository.save(userModel);

        OrderModel order = dto.convertToOrderModel();

        order.setUser(userModel);

        orderRepository.save(order);
    }

    @Override
    public BigDecimal getOrderTotalValue(Long orderId) {
        return orderRepository.findById(orderId)
                .map(OrderModel::getTotalValue)
                .orElse(new BigDecimal(0));
    }

    @Override
    public Integer orderCountByUserId(Long userId) {
       return userRepository.findById(userId)
               .map(UserModel::getQuantityOrder)
               .orElse(0);
    }

    @Override
    public List<OrderModel> findOrderByUserId(Long userId) {
       return orderRepository.findByUserUserId(userId);
    }
}
