package org.example.order.controller;

import org.example.order.service.impl.OrderService;
import org.example.pojo.Car;
import org.example.pojo.Order;
import org.example.pojo.User;
import org.example.user.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;


@RestController
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;


    @PostMapping("/all")
    public Map<String, Object> getAllOrders(@RequestBody Map<String, Object> map) {
        System.out.println(map);
        String username = map.get("username").toString();
        User user = userService.selectUser(username);
        String role = user.getRole();
        if (role.contains("admin")) {
            username = "";
        }
        List<Order> allOrders = orderService.getAllOrders(username);
        Map<String, Object> response = new HashMap<>();
        response.put("code", 0);
        response.put("msg", "");
        response.put("count", allOrders.size()); // 动态记录数
        response.put("data", allOrders);
        System.out.println(response);// 用户数据
        return response;
    }

    @PostMapping("/allList")
    public Map<String, Object> getAllOrderSelect(@RequestBody Map<String, Object> map) {
        System.out.println(map);
        String username = map.get("username").toString();
        User user = userService.selectUser(username);
        String role = user.getRole();
        if (role.contains("admin")) {
            username = "";
        }
        Integer page = (Integer) map.get("page");
        Integer pageSize = (Integer) map.get("pagesize");
        Float price = null;
        if (map.get("price").toString().isEmpty()) {
            price = 0.0F;
        } else {
            price = Float.parseFloat((String) map.get("price"));
        }
        String orderName = (String) map.get("orderName");
        String customerName = (String) map.get("customerName");
        String carCard = (String) map.get("carCard");
        String serviceName = (String) map.get("serviceName");
        Map<String, Object> response = orderService.getAllOrderSelect(username, page, pageSize, price, orderName, customerName, carCard, serviceName);
        response.put("code", 0);
        response.put("msg", "");
        return response;
    }

    @GetMapping("/mapwatch")
    public Map<String, Object> mapwatch() {
       /* String username = map.get("username").toString();
        User user = userService.selectUser(username);
        String role = user.getRole();
        if (role.contains("admin")) {
            username = "";
        }*/
        String username = "";
        List<Order> allOrders = orderService.getAllOrders(username);
        Map<String, Object> response = new HashMap<>();
        Map<String, Integer> timeCountMap = new HashMap<>();
        System.out.println("------------" + allOrders);
        for (Order order : allOrders) {
            String createTime = order.getOrderDate();
            if (timeCountMap.containsKey(createTime)) {
                timeCountMap.put(createTime, timeCountMap.get(createTime) + 1);
            } else {
                timeCountMap.put(createTime, 1);
            }
        }
        response.put("code", 0);
        response.put("msg", "");
        response.put("data", timeCountMap);
        System.out.println(response);// 用户数据
        return response;
    }

    @PostMapping("/select")
    public Map<String, Object> selectOrder(@RequestBody Order order) {
        System.out.println(order);
        List<Order> orders = orderService.selectOrder(order);
        Map<String, Object> response = new HashMap<>();
        response.put("code", 0);
        response.put("msg", "");
        response.put("count", orders.size()); // 动态记录数
        response.put("data", orders); // 用户数据
        System.out.println(response);
        return response;
    }

    @PostMapping("/create")
    public Map<String, Object> createOrder(@RequestBody Map<String, Object> map) {
        Map<String, Object> order = new HashMap<>();
                orderService.createOrder(map);
        order.put("code", 0);
        return order;
    }

    @PostMapping("/getCustomerInfo")
    public Map<String, Object> getCustomerInfo(@RequestBody Map<String, Object> map) {
        if (map.get("phoneNumber") != null &&map.get("phoneNumber") != "") {
            String phone = map.get("phoneNumber").toString();
            return orderService.getCustomerInfo(phone);
        } else {
            return null;
        }
    }
}
