package com.example.springboottest.service;

import com.example.springboottest.dao.UserMapper;
import com.example.springboottest.model.UserDto;
import com.example.springboottest.util.HttpResult;
import com.example.springboottest.util.JWTUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;

    @Override
    public HttpResult login(UserDto userDto) {
        String userName = userDto.getUsername();
        String passWord = userDto.getPassword();

        int count = userMapper.selectByUsernameAndPassword(userName,passWord );
        //模拟数据库匹配用户成功
        if(count==1){
            //返回token
            String token = JWTUtils.sign(userName, passWord);
            return HttpResult.getSuccess(token);
        }
        return HttpResult.getError("没有此用户");
    }

    @Override
    public Boolean verify(HttpServletRequest request) {
        String token = request.getHeader("token");
        return JWTUtils.verity(token);
    }
}
