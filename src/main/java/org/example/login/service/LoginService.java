package org.example.login.service;

import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface LoginService {



@Select("SELECT  * FROM user where username=#{username} and password = #{password}")
    User getUser(String username, String password);
}
