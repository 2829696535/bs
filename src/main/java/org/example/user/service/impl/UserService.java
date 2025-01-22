package org.example.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.user.mapper.UserMapper;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    private String username;

    public List<User> getAllUsers() {

        return userMapper.getAllUsers();
    }

    public void insertUser(User user) {

        String username = user.getUsername();
        String password = user.getPassword();
        String role = user.getRole();
        String createTime = user.getCreateTime();

        userMapper.insertUser(username,password,role,createTime);
    }

    public User selectUser(String id) {
        return userMapper.selectUser(id);
    }

    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }


    public void updateUser(User user) {
        String id = user.getId();
        String role = user.getRole();
        String password = user.getPassword();
        String username = user.getUsername();
        userMapper.updateUser(id,username,password,role);
    }


    public Map<String, Object> getUserlist(Integer page, Integer pagesize, String username, String role) {

        PageHelper.startPage(page, pagesize);
        List<User> userList = userMapper.getAllUserList(username, role);

        Page<User> p = (Page<User>) userList;
        Map<String, Object> map = new HashMap<>();
        map.put("total", p.getTotal());
        map.put("list", p.getResult());
        return map;
    }

}
