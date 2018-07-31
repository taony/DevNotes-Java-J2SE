package com.devnotes.j2se.io;

import java.io.*;

/**
 * @author: taony
 * @email:taonyzhang@gmail.com
 * @description:
 * @date: Created in 23:22 2018/7/24
 */
public class BufferedReaderDemo {

    public static void main(String[] args) {


        try {

            Reader reader=new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Temp\\reader.txt"),"GBK"));

            char[] chars=new char[128];

            while (reader.read(chars)>0){
                String str=new String(chars);
                System.out.println(str);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
