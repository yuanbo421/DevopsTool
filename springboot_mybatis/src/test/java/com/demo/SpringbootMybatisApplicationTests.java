package com.demo;

import com.SpringbootMybatisApplication;
import com.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapper.UserRepository;
import com.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class SpringbootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void contextLoads() throws JsonProcessingException {
        //从redis中获取数据
        String userListData = redisTemplate.boundValueOps("list").get();
        //对获得的数据进行判断
        if (userListData == null) {
            List<User> list = userRepository.findAll();
            //将查询到的数据转化为JSON数据
            ObjectMapper om = new ObjectMapper();
            userListData = om.writeValueAsString(list);
            //将查询结果存入redis中
            redisTemplate.boundValueOps("list").set(userListData);
            System.out.println("从数据库中获得数据");
        }else {
            System.out.println("从redis中获取数据");
        }

        System.out.println(userListData);


    }

}

