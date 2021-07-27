package com.learn.proxy.cglib;

public class UserDao implements IUserDao {

    public void save() {
        System.out.println("save");
    }

    public void delete() {
        System.out.println("delete");
    }

    public void saveAndDelete() {
        save();

        delete();
    }
}