package com.devnotes.j2se.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    /**
     *
     */
    public static void write() {
        String strFilePath = String.format("C:%sTemp%swriter.txt", File.separator, File.separator);
        try {

            FileWriter writer = new FileWriter(strFilePath, true);
            writer.write(new Date().toString());

            //刷新
            writer.flush();

            //关闭文件流
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
