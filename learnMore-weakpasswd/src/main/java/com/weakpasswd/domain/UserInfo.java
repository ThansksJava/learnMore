package com.weakpasswd.domain;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2021/3/31
 */
public class UserInfo {
    String username;
    String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
