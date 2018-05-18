package com.cnpc.sss.service.impl;

import com.cnpc.sss.dao.PersonReposity;
import com.cnpc.sss.domain.Person;
import com.cnpc.sss.service.TransactionService;
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
