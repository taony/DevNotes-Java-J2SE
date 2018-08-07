package com.devnotes.j2se.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

/**
 * @author: taony
 * @email:taonyzhang@gmail.com
 * @description:
 * @date: Created in 23:29 2018/7/25
 */
public class FileWriterDemo {

    public static void main(String[] args) {

        write();

    }

    public static void write(){

        String strFilePath="C:\\Temp\\writer.txt";

        try {

            Writer writer=new FileWriter(strFilePath,true);

            writer.write(new Date().toString());

            writer.flush();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
