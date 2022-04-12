package com.example.bootdemo3.service;

import com.example.bootdemo3.bean.User;

public interface UserService {
    public User getByUserNameAndPassword(User user);
}
