package com.springcloud.client.controller;

import com.learn.springcloud.entity.Dept;
import com.springcloud.client.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
    public Dept get(@PathVariable("id") Long id)
    {
        return service.get(id);
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
}
