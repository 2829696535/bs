package org.example.order.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.Service.Mapper.ServiceMapper;
import org.example.order.mapper.OrderMapper;
import org.example.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ServiceMapper serviceMapper;

    public Map<String,Object> createOrder(Map<String, Object> map) {
        String wokerName = map.get("username").toString();
        Float price = Float.parseFloat( map.get("price").toString());
        String customerName = map.get("customerName").toString();
        String phone = map.get("phone").toString();
        String carCard = map.get("carCard").toString();
        List<String> service = (List<String>) map.get("services");
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String orderDate = currentDate.format(formatter);
        String uuid = UUID.randomUUID().toString();
        StringBuilder serviceString = new StringBuilder();
        if (service != null) {
            for (int i = 0; i < service.size(); i++) {
                serviceString.append(service.get(i));
                // 如果不是最后一个元素，添加分隔符，这里以逗号为例
                if (i < service.size() - 1) {
                    serviceString.append("|");
                }
            }
        }
        String orderName = carCard + orderDate + serviceString;
        //log.info("订单服务内容{}",orderService);
        String orderState = "0";
        orderMapper.createOrder(uuid, orderName, customerName, carCard, price, wokerName, orderDate, orderState);

        if (service != null) {
            for (String item : service) {
                String uuidService = UUID.randomUUID().toString();
               int serviceState =0;
                orderMapper.createOrderInnerService( uuid,serviceState,item,uuidService);

            }
        }


        return null;
    }


    public List<Order> getAllOrders(String username) {
        return orderMapper.getAllOrders(username);
    }


    public List<Order> selectOrder(Order order) {
        System.out.println(order);
        return orderMapper.selectOrder(order);
    }

    public Map<String, Object> getAllOrderSelect(String username, Integer page, Integer pageSize, Float price, String orderName, String cusomerName, String carCard, String serviceName) {
        PageHelper.startPage(page, pageSize);
        List<Map<String, Object>> orderList = orderMapper.getAllOrderList(username, price, orderName, cusomerName, carCard, serviceName);
        System.out.println(orderList);
        Page p = (Page) orderList;
        Map<String, Object> map = new HashMap<>();

        map.put("list", p.getResult());
        map.put("total", p.getTotal());
        return map;
    }

    public Map<String, Object> getCustomerInfo(String phone) {
        Map<String, Object> customerInfo = orderMapper.getCustomerInfo(phone);
        if (customerInfo != null) {
            String id = customerInfo.get("id").toString();
            List<Map<String, Object>> carInfo = orderMapper.getCarInfo(id);
            customerInfo.put("carInfo", carInfo);
            return customerInfo;
        } else {
            return null;
        }

    }
}
