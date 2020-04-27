package com.example.springboottest.dao;

import com.example.springboottest.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select(" select * from user where id= #{id}")
    Optional<User> selectUserById(@Param("id") Integer id);

    @Select("select count(1) from user where username =#{username} and password = #{password}")
    int selectByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
}
