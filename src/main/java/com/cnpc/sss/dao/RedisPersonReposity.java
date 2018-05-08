package com.cnpc.sss.dao;

import com.cnpc.sss.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


public interface RedisPersonReposity extends JpaRepository<Person,String> {
    List<Person> findByName(String name);
    List<Person> findByNameLike(String name);
    List<Person> findByNameAndAddress(String name, String address);
    List<Person> findFirst10ByName(String name);
}
