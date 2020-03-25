package com.example.springboottest.controller;

import com.example.springboottest.model.UserDto;
import com.example.springboottest.service.LoginService;
import com.example.springboottest.util.HttpResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public HttpResult login(@RequestBody UserDto userDto){
        HttpResult httpResult = loginService.login(userDto);
        return httpResult;
    }

}
