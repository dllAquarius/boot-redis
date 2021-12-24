package com.aquarius.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/24
 * @Description:
 */
@RestController
@RequestMapping("/redisTest")
public class RedisTestController {

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/")
    public String testRedis(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 设置值到redis中
        valueOperations.set("name","lucy");
        // 从redis获取值
        String o = (String) valueOperations.get("name");
        return o;
    }

}
