package org.example.login.service.impl;

import jakarta.annotation.Resource;
import org.example.login.mapper.LoginMapper;
import org.example.login.service.LoginService;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginServiceImpl implements LoginService {

@Autowired
    LoginMapper loginMapper;


    @Override
    public User getUser(String username, String password) {
        return loginMapper.getUser(username,password);
    }
}
