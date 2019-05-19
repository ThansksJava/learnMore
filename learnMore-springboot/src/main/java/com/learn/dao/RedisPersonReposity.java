package com.learn.dao;

import com.learn.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RedisPersonReposity extends JpaRepository<Person,String> {
    List<Person> findByName(String name);
    List<Person> findByNameLike(String name);
    List<Person> findByNameAndAddress(String name, String address);
    List<Person> findFirst10ByName(String name);
}
