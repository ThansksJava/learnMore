package com.learn.springcloud.service;

import com.learn.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/17 18:49
 */
@Component
public class DeptFeignServiceFallbackFactory implements FallbackFactory<DeptFeignService> {
    @Override
    public DeptFeignService create(Throwable throwable) {
        return new DeptFeignService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                Dept errorObj = new Dept();
                errorObj.setDeptno(id).setDname("降级信息：未发现服务提供者").setDb_source("没在这个数据库中");
                return errorObj;
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
