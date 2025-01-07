package org.example.order.service.impl;

import org.example.order.mapper.OrderMapper;
import org.example.order.service.OrderService;
import org.example.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Order createOrder(Order order) {
        order.setUuid(UUID.randomUUID().toString());
        order.setOrderDate(String.valueOf(LocalDateTime.now()));
        order.setOrderState("0"); //0--创建 1--处理
        order.setOrderName(order.getOrderName() + LocalDateTime.now().toString());
        System.out.println(order);
        orderMapper.createOrder(order);
        return order;
    }

     @Override
    public List<Order> getAllOrders(String username) {

      return   orderMapper.getAllOrders(username);
    }
@Override
    public List<Order> selectOrder(Order order) {
        System.out.println(order);
        return orderMapper.selectOrder(order);
    }
}
