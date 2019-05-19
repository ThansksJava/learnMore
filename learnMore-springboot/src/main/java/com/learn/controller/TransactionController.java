package com.learn.controller;

import com.learn.domain.Person;
import com.learn.service.TransactionService;
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
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @RequestMapping("/saveWithTrans")
    public Person savePerson(){
        return transactionService.savePerson();
    }
}
