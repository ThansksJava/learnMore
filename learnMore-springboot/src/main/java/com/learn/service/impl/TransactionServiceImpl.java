package com.learn.service.impl;

import com.learn.dao.PersonReposity;
import com.learn.domain.Person;
import com.learn.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/8
 * @Time 10:25
 */
@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private PersonReposity personReposity;
    @Transactional(noRollbackFor = IllegalArgumentException.class)
    @Override
    public Person savePerson() {
        Person person = new Person("fengjie",18,"shandong");
        personReposity.save(person);
        personReposity.save(person);
        if ("fengjie".equals(person.getName())){
            throw new IllegalArgumentException();
        }
        return person;
    }
}
