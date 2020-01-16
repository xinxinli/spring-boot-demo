package com.eshore.project.springbootdemo.param;

import com.eshore.project.springbootdemo.util.QueryBase;

public class UserParam extends QueryBase {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
