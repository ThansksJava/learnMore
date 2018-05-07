package com.cnpc.sss.dao;

import com.cnpc.sss.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonReposity extends JpaRepository<Person,Long> {
    List<Person> findByName(String name);
    List<Person> findByNameLike(String name);
    List<Person> findByNameAndAddress(String name,String address);
    List<Person> findFirst10ByName(String name);
}
