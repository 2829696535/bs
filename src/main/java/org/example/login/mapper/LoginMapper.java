package org.example.login.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;

import java.util.Map;

@Mapper
public interface LoginMapper {

    @Select("select * from user where username = #{username} and password = #{password}")
    User getUser(@Param("username") String username, @Param("password") String password);

@Select("select * from `user` where username = #{username}")
Map<String, Object> checkUserName(@Param("username") String username);
@Insert("insert into  user (username, password, role, create_time) values (#{username},#{password},#{role},#{createDate})")
    void register(@Param("username") String username, @Param("password") String password,
                  @Param("role") String role,@Param("createDate") String createDate);
}