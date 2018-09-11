package com.devnotes.j2se.io;

import com.devnotes.j2se.io.common.FileTestUtil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PushbackInputStream;

/**
 *
 */
public class PushbackInputStreamDemo {

    public static void main(String[] args) {
        try {

            InputStream         is  = new FileInputStream(FileTestUtil.getTempDir() + "PushbackInputStreamDemo.txt");
            PushbackInputStream pis = new PushbackInputStream(is, 2);

            int temp = 0;
            while ((temp = pis.read()) > 0) {
                if (temp == '-') {
                    pis.unread(temp);
                    temp = pis.read() ;
                    System.out.println("(退回)"+(char)temp);
                }else{
                    System.out.println((char)temp);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
