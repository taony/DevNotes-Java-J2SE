package com.devnotes.j2se.io;

import com.devnotes.j2se.io.common.FileTestUtil;

import java.io.*;

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


        User               user = new User("zhangsan", "123456", 5);
        File               file = new File(FileTestUtil.getTempDir() + "ObjectOutputStream.txt");
        FileOutputStream   fos  = new FileOutputStream(file);
        ObjectOutputStream os   = new ObjectOutputStream(fos);
        os.writeObject(user);
        os.close();
    }


}

class User implements Serializable {
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

    /**
     * 自定义序列化方法
     * @param os
     * @throws Exception
     */
    private void writeObject(ObjectOutputStream os) throws Exception{
        os.defaultWriteObject();
    }

    /**
     * 自定义反序列化方法
     * @param is
     * @throws Exception
     */
    private void readOjbect(ObjectInputStream is) throws Exception {
        is.defaultReadObject();
    }

}
