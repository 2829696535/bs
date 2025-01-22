package org.example.login.service;

import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface LoginService {
    User getUser(String username, String password);
}
