package com.example.springboottest.controller;

import com.example.springboottest.model.UserDto;
import com.example.springboottest.service.LoginService;
import com.example.springboottest.util.HttpResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/loginController")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping(value = "/login")
    public ResponseEntity<HttpResult> login(String username,String password){
        UserDto userDto  = new UserDto();
        userDto.setUsername(username);
        userDto.setPassword(password);
        HttpResult httpResult = loginService.login(userDto);
        return ResponseEntity.ok(httpResult);
    }

}
