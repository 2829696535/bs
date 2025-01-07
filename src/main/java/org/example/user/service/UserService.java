package org.example.user.service;

import org.example.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> getAllUsers();
    public void insertUser(User user);
    public User selectUser(String id);
    public void deleteUser(User user);
    public void updateUser(User user);
}
