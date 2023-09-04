package com.demo;

import com.domain.User;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author YUANBO
 * @create 2019-02-16 19:25
 **/
@RestController
public class MybatisTestController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/query")
    public User queryUser(){
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
        return user;
    }
}
