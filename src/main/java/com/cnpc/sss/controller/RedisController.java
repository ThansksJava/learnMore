package com.cnpc.sss.controller;

import com.cnpc.sss.domain.Person;
import com.cnpc.sss.service.RedisService;
import com.cnpc.sss.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/8
 * @Time 10:21
 */
@RestController
public class RedisController {
    @Autowired
    private RedisService redisService;
    @RequestMapping("/saveWithRedis")
    public Person savePerson(){
        return redisService.savePerson();
    }
}
