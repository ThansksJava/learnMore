package com.cnpc.sss.domain;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Component
//@ConfigurationProperties(prefix = "person")
@Entity
public class Person {
    private long id;
    private String name;
    private int age;
    private String address;
    @Id
    @GenericGenerator(strategy = "uuid",name="pk_person")
    @GeneratedValue(generator = "pk_person")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "name" )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Column
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
