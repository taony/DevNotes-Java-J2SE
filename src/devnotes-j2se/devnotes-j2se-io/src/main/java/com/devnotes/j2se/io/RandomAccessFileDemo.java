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
        writeData();
    }

    public static void writeData() {
        File file = new File(FileTestUtil.getTempDir() + "RandomAccessFileDemo_Write.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.writeChars(UUID.randomUUID().toString());
            raf.writeBoolean(new Boolean("1"));
            raf.write(1);
            raf.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
