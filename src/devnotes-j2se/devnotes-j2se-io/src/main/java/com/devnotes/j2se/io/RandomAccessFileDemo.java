package com.devnotes.j2se.io;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.UUID;

public class RandomAccessFileDemo {

    public static void main(String[] args) {
        testRaf();
    }


    public static void testRaf() {

        File file = new File("/resources/temp/RandomAccessFileDemo.txt");

        try {

            if (!file.exists()) {
                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            raf.writeChars(UUID.randomUUID().toString());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
