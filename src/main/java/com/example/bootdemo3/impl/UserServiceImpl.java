package com.example.bootdemo3.impl;

import com.example.bootdemo3.bean.User;
import com.example.bootdemo3.mapper.UserMapper;
import com.example.bootdemo3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getByUserNameAndPassword(User user) {
        return null;
    }
}
