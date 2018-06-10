package com.devnotes.j2se.io.inputstreamdemo;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) {

        crateNewFile();
    }

    static void crateNewFile(){
        File file=new File("c:\\crateNewFile.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
