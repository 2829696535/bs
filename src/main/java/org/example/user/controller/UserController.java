package org.example.user.controller;

import org.example.user.service.UserService;
import org.example.user.service.impl.UserServiceImpl;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public  Map<String, Object> getAllUsers(){
        List<User> users = userService.getAllUsers();
        Map<String, Object> response = new HashMap<>();
        response.put("code", 0);
        response.put("msg", "");
        response.put("count", users.size()); // 动态记录数
        response.put("data", users); // 用户数据
        System.out.println(response);
        return response;
    }
    @PostMapping("/insertUser")
    public  Map<String, Object> insertUser(@RequestBody Map<String,Object> map){
        User user = new User();
        System.out.println(map);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 获取当前日期
        Date date = new Date();
        // 将日期格式化为字符串
        String formattedDate = sdf.format(date);
        user.setCreate_time(formattedDate);
        String uuid = String.valueOf(UUID.randomUUID());
        user.setId(uuid);
        user.setRole((String) map.get("role"));
        user.setUsername((String) map.get("username"));
        user.setPassword((String) map.get("password"));


        userService.insertUser(user);
        Map<String, Object> response = new HashMap<>();
        response.put("code", 0);
        response.put("msg", "success");

        return response;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("出现错误: " + e.getMessage());
    }
    @PostMapping("/selectUser")
    public User selectUser(@RequestBody String id ){

        String[] parts = id.split("=");
        String number =  parts[1];
        System.out.println(number);
        User users = userService.selectUser(number);
        return users;

    }
    @PostMapping("/updateUser")
    public Map<String, Object>  updateUser(@RequestBody User user){
        System.out.println(user);

        userService.updateUser(user);
    Map<String, Object> response = new HashMap<>();
    response.put("code", 0);
    response.put("msg", "success");
    return response;


}


}

