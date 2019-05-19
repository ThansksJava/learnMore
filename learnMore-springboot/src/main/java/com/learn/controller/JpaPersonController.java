package com.learn.controller;

import com.learn.dao.PersonReposity;
import com.learn.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/7
 * @Time 13:51
 */
@RestController
public class JpaPersonController {
    @Autowired
    private PersonReposity personReposity;
    @RequestMapping("/save")
    public Person savePerson(){
        Person person = new Person("fengjie",18,"shandong");
        personReposity.save(person);
        return person;
    }
    @RequestMapping("/getPersonByname")
    public List<Person> getPersonByName(){
        return personReposity.findByName("fengjie");
    }
}
