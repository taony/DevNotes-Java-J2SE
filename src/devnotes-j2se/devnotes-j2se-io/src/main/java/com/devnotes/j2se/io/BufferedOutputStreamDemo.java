package com.devnotes.j2se.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author: taony
 * @email:taonyzhang@gmail.com
 * @description:
 * @date: Created in 23:32 2018/6/29
 */
public class BufferedOutputStreamDemo {

    public static void main(String[] args) {
        copyFile();
    }

    private static void copyFile() {
        String file1 = "C:\\1.png";
        String file2 = "C:\\2.png";

        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file1));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file2));
            byte[] b = new byte[1024];
            String content = "";
            int len = 0;
            while ((len = bis.read(b)) != -1) {
                System.out.println(content);
                bos.write(b, 0, len);
            }
            bis.close();
            bos.close();
            bos.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
