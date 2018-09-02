package com.devnotes.j2se.io;

import java.io.File;
import java.io.FileReader;

/**
 * @author Administrator
 */
public class FilterReaderDemo {

    public static void main(String[] args) {

        try {
            var file   = new File("C:\\temp\\FilterReaderDemo.txt");
            var reader = new FileReader(file);
            var arr    = new char[1024];
            while (reader.read(arr) > 0) {
                System.out.println(new String(arr));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
