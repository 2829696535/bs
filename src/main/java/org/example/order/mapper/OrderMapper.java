package org.example.order.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Order;

import java.util.List;
@Mapper
public interface OrderMapper {
     void createOrder(Order order);

     List<Order>getAllOrders(String username);

      List<Order> selectOrder(Order order);
}
