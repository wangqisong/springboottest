package com.example.springboottest.service;

import com.example.springboottest.dao.UserMapper;
import com.example.springboottest.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Optional<User> getUserById(Integer id) {
        Optional<User> user = userMapper.selectUserById(id);
        return user;
    }
}
