package com.devnotes.j2se.io;

import jdk.internal.dynalink.beans.StaticClass;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class ReaderDemo {

    public static void main(String[] args) {
        read();
    }

    public static String read() {
        try {

            File file = new File("C:\\Temp\\RandomAccessFileDemo.txt");

            Reader reader=new FileReader(file);

            char[] chars=new char[1024];

            int len= reader.read(chars);

            reader.close();

            System.out.println(new String(chars,0,len));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
