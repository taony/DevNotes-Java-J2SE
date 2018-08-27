package com.devnotes.j2se.io;

import com.devnotes.j2se.io.common.FileTestUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author: taony
 * @email:taonyzhang@gmail.com
 * @description:
 * @date: Created in 23:49 2018/8/2
 */
public class ObjectOutputStreamDemo {


    public static void main(String[] args) throws Exception {

        outputObject();

    }

    public static void outputObject() throws Exception {

        User user = new User("zhangsan", "123456", 5);

        File file = new File(FileTestUtil.getTempDir() + "ObjectOutputStream.txt");

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

        outputStream.writeObject(user);

        outputStream.close();

    }


}

class User implements Serializable {

    private String  userName;
    private String  userPwd;
    private transient Integer age;


    public User() {

    }

    public User(String name, String pwd, int age) {
        this.userName = name;
        this.userPwd = pwd;
        this.age = age;
    }
}
