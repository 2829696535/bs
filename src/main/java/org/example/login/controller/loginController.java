package org.example.login.controller;

import org.example.user.service.impl.UserService;
import org.example.login.service.LoginService;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/index")
public class loginController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    public Map<String,Object> loginUser(@RequestBody Map<String,Object> data) {
        System.out.println(data);
        String username = (String) data.get("username");
        String password = (String) data.get("password");

        User user = loginService.getUser(username, password);

        Map<String,Object> response = new HashMap<String,Object>();
        response.put("code", 0);
        response.put("msg", "");
        response.put("user",user);
        System.out.println(response);
        return response;

    }

}
