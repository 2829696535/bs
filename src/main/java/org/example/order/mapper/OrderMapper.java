package org.example.order.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Order;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Mapper
public interface OrderMapper {


     List<Order>getAllOrders(String username);

      List<Order> selectOrder(Order order);

    List<Map<String,Object>> getAllOrderList(@Param("username") String username, @Param("price") Float price,
                              @Param("orderName") String orderName, @Param("customerName") String customerName,
                              @Param("carCard") String carCard, @Param("service") String serviceName);
@Select("select * from customer  where phone_number =#{phone}")
   Map<String,Object> getCustomerInfo(@Param("phone") String phone);
@Select("select car_name as carName ,car.car_card from car where owner_id= #{id}")
    List<Map<String,Object>> getCarInfo(@Param("id") String id);
@Insert("insert into  `order` (uuid, order_name, customer_name, car_card, order_price, worker_name, order_date,order_state) values " +
        "(#{uuid},#{orderName},#{customerName},#{carCard},#{price},#{wokerName},#{orderDate},#{orderState})")
    void createOrder(@Param("uuid") String uuid, @Param("orderName")String orderName, @Param("customerName")String customerName,
                     @Param("carCard")String carCard, @Param("price")Float price, @Param("wokerName")String wokerName,
                     @Param("orderDate")String orderDate,@Param("orderState") String orderState);
@Insert("insert into  order_inner_service (inner_uuid, service_name,uuid ,service_state) VALUES " +
        "(#{uuid},#{item},#{uuidService},#{serviceState})")
    void createOrderInnerService(@Param("uuid") String uuid, @Param("serviceState") int serviceState,
                                 @Param("item") String item,@Param("uuidService")  String uuidService);
}
