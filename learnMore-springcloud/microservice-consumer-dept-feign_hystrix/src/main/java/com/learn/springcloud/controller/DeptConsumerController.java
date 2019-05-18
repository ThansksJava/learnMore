package com.learn.springcloud.controller;

import com.learn.springcloud.entity.Dept;
import com.learn.springcloud.service.DeptFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/12 19:49
 */
@RestController
public class DeptConsumerController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private DeptFeignService service;

    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept)
    {
        return service.add(dept);
    }

    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return service.get(id);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list()
    {
        return service.list();
    }
}
