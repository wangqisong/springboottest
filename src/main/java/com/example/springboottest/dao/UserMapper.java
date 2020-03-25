package com.example.springboottest.dao;

import com.example.springboottest.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select(" select * from user where id= #{id}")
    User selectUserById(@Param("id") Integer id);
}
