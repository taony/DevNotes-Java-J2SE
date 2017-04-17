package com.devnotes.j2se.io;

import java.io.*;

/**
 * Created by taony on 2017/4/8.
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) {
        try {

            File file = new File("raf.txt");

            write(file);

            read(file);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //写入数据
    private static void write(File file) {
        try {

            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            for (int i = 0; i < 100; i++) {
                raf.writeInt(i);
            }

            raf.writeBytes("Hello World");

            raf.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //读取数据
    private static void read(File file) {
        try {

            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            byte b = raf.readByte();

            System.out.print(b);

            raf.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

