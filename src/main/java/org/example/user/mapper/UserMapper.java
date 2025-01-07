package org.example.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;

import java.util.List;
@Mapper
public interface UserMapper {
@Select("select * from users")
   List<User> getAllUsers();

    void insertUser(User user);
@Select("SELECT * FROM user where id = #{id}")
    User selectUser(String id);

    void deleteUser(User user);



    void updateUser(User user);
}
