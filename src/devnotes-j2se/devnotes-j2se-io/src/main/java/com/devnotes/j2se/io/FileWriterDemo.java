package com.devnotes.j2se.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author: taony
 * @email:taonyzhang@gmail.com
 * @description:
 * @date: Created in 23:29 2018/7/25
 */
public class FileWriterDemo {

    public static void main(String[] args) {
        String strFilePath="C:\\Temp\\RandomAccessFileDemo.txt";
        try {
            Writer writer=new FileWriter(strFilePath,true);

            writer.write("Hello World");

            writer.flush();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
