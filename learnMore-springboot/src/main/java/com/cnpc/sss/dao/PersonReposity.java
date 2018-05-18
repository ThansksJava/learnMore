package com.cnpc.sss.dao;

import com.cnpc.sss.domain.Person;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


import java.util.List;
/**
 *RepositoryRestResource 自定义路径 默认是实体类的小写复数
 */
@RepositoryRestResource(path = "people")
public interface PersonReposity extends JpaRepository<Person,String> {
    //TODO 2018年5月8日10:20:17 http://localhost:8089/learnMore/people/findByName?name=fengjie此处不生效
    @RestResource(path = "findByName",rel = "findByName")
    List<Person> findByName(@Param("name")String name);
    List<Person> findByNameLike(String name);
    List<Person> findByNameAndAddress(String name,String address);
    List<Person> findFirst10ByName(String name);
}
