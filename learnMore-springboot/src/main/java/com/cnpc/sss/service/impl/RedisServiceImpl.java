package com.cnpc.sss.service.impl;

import com.cnpc.sss.dao.PersonReposity;
import com.cnpc.sss.domain.Person;
import com.cnpc.sss.service.RedisService;
import com.cnpc.sss.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/8
 * @Time 10:25
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private PersonReposity personReposity;
    @Override
    @CachePut(value = "people")
    public Person savePerson() {
        Person person = new Person("fengjie",18,"shandong");
        personReposity.save(person);
        return person;
    }
}
