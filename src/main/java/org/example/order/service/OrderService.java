package org.example.order.service;

import org.example.pojo.Order;

import java.util.List;

public interface OrderService {
    public Order createOrder(Order order);
    public List<Order> getAllOrders(String username);
    public List<Order> selectOrder(Order order);
}
