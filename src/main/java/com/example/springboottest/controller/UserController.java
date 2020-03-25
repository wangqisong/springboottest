package com.example.springboottest.controller;

import com.example.springboottest.model.User;
import com.example.springboottest.model.UserDto;
import com.example.springboottest.service.LoginService;
import com.example.springboottest.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private LoginService loginService;

    @GetMapping("/getUserById")
    public UserDto getUserById(HttpServletRequest request, Integer id){
        if (!loginService.verify(request)){
            throw new RuntimeException("没有登陆");
        }
        User user = userService.getUserById(id);

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);

        return userDto;
    }
}
