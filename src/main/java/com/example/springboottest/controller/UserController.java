package com.example.springboottest.controller;

import com.example.springboottest.model.User;
import com.example.springboottest.model.UserDto;
import com.example.springboottest.service.LoginService;
import com.example.springboottest.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/userController")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private LoginService loginService;

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserDto> getUserById(HttpServletRequest request,@PathVariable Integer id) {
        if (!loginService.verify(request)) {
            throw new RuntimeException("没有登陆");
        }
        Optional<User> userOptional = userService.getUserById(id);
        if (!userOptional.isPresent()) {
            return  ResponseEntity.notFound().build();
        }
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userOptional.get(), userDto);

        return ResponseEntity.ok(userDto);
    }
}
