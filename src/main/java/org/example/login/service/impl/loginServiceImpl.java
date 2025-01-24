package org.example.login.service.impl;
import org.example.login.mapper.LoginMapper;
import org.example.login.service.LoginService;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
