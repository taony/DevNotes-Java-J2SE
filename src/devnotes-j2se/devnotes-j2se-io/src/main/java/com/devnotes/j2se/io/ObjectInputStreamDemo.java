package com.devnotes.j2se.io;

import com.devnotes.j2se.io.common.FileTestUtil;
import com.devnotes.j2se.io.bo.SerialBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author: taony
 * @email:taonyzhang@gmail.com
 * @description:
 * @date: Created in 23:53 2018/8/2
 */
public class ObjectInputStreamDemo {

    public static void main(String[] args) throws Exception {
        var file = new File(FileTestUtil.getTempDir() + "ObjectOutputStream.txt");
        var fis  = new FileInputStream(file);
        var ois  = new ObjectInputStream(fis);
        var user = (SerialBean) ois.readObject();
        System.out.println(user);
        ois.close();
    }
}
