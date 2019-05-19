package com.learn.domain.auth;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/9
 * @Time 14:11
 */
@Entity
public class SysRole {
    @Id
    @GenericGenerator(strategy = "uuid",name="pk_role")
    @GeneratedValue(generator = "pk_role")
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
