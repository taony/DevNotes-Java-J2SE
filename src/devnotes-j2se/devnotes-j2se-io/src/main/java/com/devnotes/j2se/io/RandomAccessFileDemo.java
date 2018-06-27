package com.devnotes.j2se.io;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.UUID;

public class RandomAccessFileDemo {

    public void testRaf(){
        File file=new File("C://Temp/RandomAccessFileDemo.txt");
        try {

            if(!file.exists()){
                file.createNewFile();
            }
            RandomAccessFile raf=new RandomAccessFile(file, "rw");
            raf.writeChars(UUID.randomUUID().toString());


        }catch (Exception ex){

        }
    }
}
