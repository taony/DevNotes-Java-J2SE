package com.devnotes.j2se.io;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

    public static void main(String[] args) {

    }

    public void testRaf(){

        File file=new File(".");

        try {
            RandomAccessFile raf1=new RandomAccessFile(file, "r");

            raf1.read();

        }catch (Exception ex){

        }
    }
}
