package com.devnotes.j2se.io;

import com.devnotes.j2se.io.common.FileTestUtil;
import com.devnotes.j2se.io.bo.SerialBean;

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

        var user = new SerialBean("zhangsan", "123456", 5);
        var file = new File(FileTestUtil.getTempDir() + "ObjectOutputStream.txt");
        var fos  = new FileOutputStream(file);
        var os   = new ObjectOutputStream(fos);

        os.writeObject(user);
        os.close();
    }


}

