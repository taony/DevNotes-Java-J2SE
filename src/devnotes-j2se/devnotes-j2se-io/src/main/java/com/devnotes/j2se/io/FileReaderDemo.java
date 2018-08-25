package com.devnotes.j2se.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterReader;

/**
 * @author: taony
 * @email:taonyzhang@gmail.com
 * @description:
 * @date: Created in 23:15 2018/7/24
 */
public class FileReaderDemo {

    public static void main(String[] args) {
        try {
            FileReader fileReader=new FileReader(new File(""));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
