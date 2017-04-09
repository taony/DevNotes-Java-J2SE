package com.devnotes.j2se.io;

import java.io.*;

/**
 * Created by taony on 2017/4/8.
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) {

        String pathRoot = RandomAccessFileDemo.class.getProtectionDomain().getCodeSource().getLocation().toString();

        try {

            System.out.print(pathRoot);

            File file = new File(pathRoot + "/files/raf.txt");

            System.out.print(file.length());

            write(file);

            read(file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void write(File file) {
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            raf.writeInt(1);
            raf.writeBytes("Hello World");

            raf.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

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

