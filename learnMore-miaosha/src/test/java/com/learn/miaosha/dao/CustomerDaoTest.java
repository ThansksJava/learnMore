package com.learn.miaosha.dao;

import com.learn.miaosha.MiaoShaApplication;
import com.learn.miaosha.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author fengjie
 * @version 1.0
 * @date 2019/7/6
 */
@SpringBootTest(classes = MiaoShaApplication.class)
@RunWith(SpringRunner.class)
public class CustomerDaoTest {
    @Autowired
    private CustomerDao customerDao;
    @Test
    public void add() {
        Customer customer = new Customer();
        customer.setCustomerId(UUID.randomUUID().toString().replace("-",""));
        customer.setCustomerName("Jerry");
        customerDao.add(customer);
    }
}