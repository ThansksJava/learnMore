package com.learn.springcloud.service;

import com.learn.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/17 18:49
 */
@FeignClient(value = "MICROSERVICE-DEPT")
public interface DeptFeignService {
    @RequestMapping(value="/dept/add")
    boolean add(Dept dept);
    @RequestMapping(value="/dept/get/{id}")
    Dept get(@PathVariable("id") Long id);
    @RequestMapping(value="/dept/list")
    List<Dept> list();
}
