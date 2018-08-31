package com.devnotes.j2se.io.object_demo;

import java.io.*;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private           String  userName;
    private           String  userPwd;
    private transient Integer age;

    //序列化对象不需要提供默认构造器，序列化时不需要依赖于默认构造器
    public User(String name, String pwd, int age) {
        this.userName = name;
        this.userPwd = pwd;
        this.age = age;
    }
}
