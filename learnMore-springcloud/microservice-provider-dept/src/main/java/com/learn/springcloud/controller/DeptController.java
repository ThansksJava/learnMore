package com.learn.springcloud.controller;

import com.learn.springcloud.entity.Dept;
import com.learn.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/12 18:43
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @PostMapping(value="/dept/add")
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @GetMapping(value="/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return service.get(id);
    }

    @GetMapping(value="/dept/list")
    public List<Dept> list()
    {
        return service.list();
    }

}
