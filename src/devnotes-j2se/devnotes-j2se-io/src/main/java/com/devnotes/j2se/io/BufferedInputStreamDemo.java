package com.devnotes.j2se.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * @author: taony
 * @email:taonyzhang@gmail.com
 * @description:
 * @date: Created in 23:32 2018/6/29
 */
public class BufferedInputStreamDemo {

    public static void main(String[] args) {
        try {
            FileInputStream fis=new FileInputStream("BISDemo.txt");
            BufferedInputStream bis=new BufferedInputStream(fis);
            String content=null;

            //自己定义一个缓冲区
            byte[] buffer=new byte[10240];
            int flag=0;

            while((flag=bis.read(buffer))!=-1){
                content+=new String(buffer, 0, flag);
            }

            System.out.println(content);

            //关闭的时候只需要关闭最外层的流就行了
            bis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
