package org.example.order.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
@Select("select * from customer  where phone_number =#{phone}")
   Map<String,Object> getCustomerInfo(@Param("phone") String phone);
@Select("select car_name as carName ,car.car_card from car where owner_id= #{id}")
    List<Map<String,Object>> getCarInfo(@Param("id") String id);
}
