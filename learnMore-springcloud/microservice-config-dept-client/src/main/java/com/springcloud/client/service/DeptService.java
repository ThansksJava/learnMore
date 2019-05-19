package com.springcloud.client.service;

import com.learn.springcloud.entity.Dept;

import java.util.List;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/12 18:40
 */
public interface DeptService {
    boolean add(Dept dept);
    Dept get(Long id);
    List<Dept> list();
}
