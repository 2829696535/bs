package org.example.login.service;
import org.example.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface LoginService {
    User getUser(String username, String password);

    Map<String,Object> checkUserName(String username);
}
