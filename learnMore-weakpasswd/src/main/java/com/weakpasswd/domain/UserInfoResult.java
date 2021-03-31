package com.weakpasswd.domain;

import javax.swing.text.StyledEditorKit;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2021/3/31
 */
public class UserInfoResult {
    String username;
    String password;
    String needModify;
    String comments;

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

    public String getNeedModify() {
        return needModify;
    }

    public void setNeedModify(String needModify) {
        this.needModify = needModify;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "UserInfoResult{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", needModify='" + needModify + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
