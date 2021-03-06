package com.devnotes.j2se.io;

import java.io.*;

public class ReaderDemo {

    public static void main(String[] args) {
        read();
    }

    public static String read() {
        try {

            File file = new File("C:\\Temp\\RandomAccessFileDemo.txt");

            BufferedReader reader =new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK")) ;

            char[] chars = new char[1024];

            int len = 0;

            while ((len = reader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, len));
            }

            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
