package com.devnotes.j2se.io;

import com.devnotes.j2se.io.common.FileTestUtil;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.UUID;

/**
 * @author Administrator
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) {
        //输出数据
        write();
    }

    public static void write() {
        File file = new File(FileTestUtil.getTempDir() + "RandomAccessFileDemo_Write.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "w");
            raf.writeChars(UUID.randomUUID().toString());
            raf.writeBoolean(new Boolean("1"));
            raf.write(1);
            raf.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void read(){
        File file = new File(FileTestUtil.getTempDir() + "RandomAccessFileDemo.txt");
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            Byte[] bytes=new Byte[1024];
            raf.readFully(bytes);
            raf.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
