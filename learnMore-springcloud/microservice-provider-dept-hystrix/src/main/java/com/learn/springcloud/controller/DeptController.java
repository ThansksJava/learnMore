package com.learn.springcloud.controller;

import com.learn.springcloud.entity.Dept;
import com.learn.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.simple.SimpleDiscoveryClient;
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
    @Autowired
    private DiscoveryClient simpleDiscoveryClient;
    @PostMapping(value="/dept/add")
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @GetMapping(value="/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "whenSomeBadThings")
    public Dept get(@PathVariable("id") Long id)
    {
        Dept dept = service.get(id);
        if(dept == null){
            throw new RuntimeException("该ID不存在");
        }
        return dept;
    }

    @GetMapping(value="/dept/list")
    public List<Dept> list()
    {
        return service.list();
    }
    @GetMapping(value="/dept/discovery")
    public Object discovery(){
        List<String> list = simpleDiscoveryClient.getServices();
        System.out.println("所有的服务："+list);
        List<ServiceInstance> serviceInstanceList = simpleDiscoveryClient.getInstances("microservice-dept");
        for(ServiceInstance instance : serviceInstanceList){
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getUri());
        }
        return this.simpleDiscoveryClient;
    }

    public Dept whenSomeBadThings(@PathVariable("id") Long id){
        Dept errorObj = new Dept();
        errorObj.setDeptno(id).setDname("该ID没有对应信息").setDb_source("没在这个数据库中");
        return errorObj;
    }

}
