package com.demo.springbootsimple.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.springbootsimple.entity.User;
import com.demo.springbootsimple.mapper.UserMapper;
import com.demo.springbootsimple.service.UserService;
import org.springframework.stereotype.Service;

@Service  //创建一个service对象
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
