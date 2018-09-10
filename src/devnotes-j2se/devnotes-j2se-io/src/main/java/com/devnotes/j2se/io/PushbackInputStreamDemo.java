package com.devnotes.j2se.io;

import com.devnotes.j2se.io.common.FileTestUtil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class PushbackInputStreamDemo {

    public static void main(String[] args) {
        try {

            InputStream         is  = new FileInputStream(FileTestUtil.getTempDir() + "PushbackInputStreamDemo.txt");
            PushbackInputStream pis = new PushbackInputStream(is);

            byte[] bytes = new byte[2];

            while (pis.read(bytes) > 0) {
                System.out.println(new String(bytes));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
