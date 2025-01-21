package org.example.order.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Order;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
     void createOrder(Order order);

     List<Order>getAllOrders(String username);

      List<Order> selectOrder(Order order);

    List<Map<String,Object>> getAllOrderList(@Param("username") String username, @Param("price") Float price,
                              @Param("orderName") String orderName, @Param("customerName") String customerName,
                              @Param("carCard") String carCard, @Param("service") String serviceName);
}
