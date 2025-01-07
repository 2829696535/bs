package org.example.user.service.impl;

import org.example.user.mapper.UserMapper;
import org.example.pojo.User;
import org.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
  @Autowired
   private  UserMapper userMapper;
    @Override
    public List<User> getAllUsers() {

        return userMapper.getAllUsers();
    }
    @Override
    public void insertUser(User user) {

        userMapper.insertUser(user);
    }
    @Override
    public User selectUser(String id) {
      return  userMapper.selectUser(id);
    }
    @Override
    public void deleteUser(User user) { userMapper.deleteUser(user); }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }



}
