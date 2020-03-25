package com.example.springboottest.service;

import com.example.springboottest.model.UserDto;
import com.example.springboottest.util.HttpResult;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
    HttpResult login(UserDto userDto);

    Boolean verify(HttpServletRequest request);
}
