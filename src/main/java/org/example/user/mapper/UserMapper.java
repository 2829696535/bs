package org.example.user.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.example.pojo.User;

import java.util.List;
@Mapper
public interface UserMapper {
@Select("select * from user")
   List<User> getAllUsers();

    List<User> getAllUserList(@Param("username") String username, @Param("role") String role);
@Insert("insert  into `user` (username ,password,role,create_time) values (#{username},#{password},#{role},#{createTime})")
    void insertUser(@Param("username") String username,@Param("password") String password,
                    @Param("role") String role,@Param("createTime") String createTime);
@Select("SELECT * FROM user where id = #{id}")
    User selectUser(String id);
@Delete("delete from `user` where id = #{id}")
    void deleteUser(@Param("id") Integer id);


@Select("")
    void updateUser(User user);
}
