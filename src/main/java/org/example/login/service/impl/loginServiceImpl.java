package org.example.login.service.impl;
import org.example.login.mapper.LoginMapper;
import org.example.login.service.LoginService;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class loginServiceImpl implements LoginService {

@Autowired
    LoginMapper loginMapper;
    @Override
    public User getUser(String username, String password) {
        return loginMapper.getUser(username,password);
    }

    @Override
    public Map<String, Object> checkUserName(String username) {
        Map<String, Object> isHas = loginMapper.checkUserName(username);
        Map<String,Object> map =new HashMap<>();
        if(isHas==null) {
            map.put("isHas",false);
        }else {
            map.put("isHas",true);
        }
        return map;
    }

    @Override
    public Map<String, Object> register(Map<String, Object> map) {
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String createDate = currentDate.format(formatter);
        String role = "user";
        loginMapper.register(username,password,role,createDate);
        Map<String,Object> resmap = new HashMap<>();
        resmap.put("code",0);
        return resmap;
    }
}
