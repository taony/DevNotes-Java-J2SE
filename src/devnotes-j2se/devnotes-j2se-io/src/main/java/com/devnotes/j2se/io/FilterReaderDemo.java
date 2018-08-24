package com.devnotes.j2se.io;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class FilterReaderDemo {

    public static void main(String[] args) {

        try {
            File file = new File("C:\\temp\\FilterReaderDemo.txt");
            Reader reader = new FileReader(file);
            char[] arr = new char[1024];
            while (reader.read(arr) > 0) {
                System.out.println(new String(arr));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
