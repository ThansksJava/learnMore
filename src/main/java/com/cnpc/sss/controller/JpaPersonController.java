package com.cnpc.sss.controller;

import com.cnpc.sss.dao.PersonReposity;
import com.cnpc.sss.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/7
 * @Time 13:51
 */
@Controller
public class JpaPersonController {
    @Autowired
    private PersonReposity personReposity;
    @RequestMapping("/save")
    public void savePerson(){
        personReposity.save(new Person("fengjie",18,"shandong"));
    }
}
