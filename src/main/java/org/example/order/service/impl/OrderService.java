package org.example.order.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.order.mapper.OrderMapper;
import org.example.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public Order createOrder(Order order) {
        order.setUuid(UUID.randomUUID().toString());
        order.setOrderDate(String.valueOf(LocalDateTime.now()));
        order.setOrderState("0"); //0--创建 1--处理
        order.setOrderName(order.getOrderName() + LocalDateTime.now().toString());
        System.out.println(order);
        orderMapper.createOrder(order);
        return order;
    }


    public List<Order> getAllOrders(String username) {
        return orderMapper.getAllOrders(username);
    }


    public List<Order> selectOrder(Order order) {
        System.out.println(order);
        return orderMapper.selectOrder(order);
    }

    public Map<String, Object> getAllOrderSelect(String username, Integer page, Integer pageSize, Float price, String orderName, String cusomerName,String carCard ,String serviceName) {
        PageHelper.startPage(page, pageSize);
        List<Map<String,Object>> orderList = orderMapper.getAllOrderList(username, price, orderName, cusomerName,carCard,serviceName);
        System.out.println(orderList);
        Page p = (Page) orderList;
        Map<String, Object> map = new HashMap<>();
        map.put("list", p.getResult());
        map.put("total", p.getTotal());
        return map;


    }
}
