package com.learn.service.impl;

import com.learn.dao.PersonReposity;
import com.learn.domain.Person;
import com.learn.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

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
