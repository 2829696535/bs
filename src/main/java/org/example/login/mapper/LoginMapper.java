package org.example.login.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;

@Mapper
public interface LoginMapper {

    @Select("select * from user where username = #{username} and password = #{password}")
    User getUser(@Param("username") String username, @Param("password") String password);


}