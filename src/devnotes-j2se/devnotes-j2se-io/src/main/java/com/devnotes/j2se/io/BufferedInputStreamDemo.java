package com.devnotes.j2se.io;

import java.io.*;

/**
 * @author: taony
 * @email:taonyzhang@gmail.com
 * @description:
 * @date: Created in 23:32 2018/6/29
 */
public class BufferedInputStreamDemo {

    public static void main(String[] args) {
        //readFile();

        copyFile();
    }

    private static void readFile() {
        try {
            File file = new File("C:\\txt.log");
            if (null != file) {
                System.out.println(file.length());
            }
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            String content = null;
            //自己定义一个缓冲区
            byte[] buffer = new byte[1024];
            int flag = 0;

            while ((flag = bis.read(buffer)) != -1) {
                System.out.println("flag:" + flag);
                content += new String(buffer, 0, flag);
            }

            System.out.println(content);
            //关闭的时候只需要关闭最外层的流就行了
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void copyFile() {
        String file1 = "C:\\1.png";
        String file2 = "C:\\2.png";

        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file1));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file2));
            byte[] b = new byte[128];
            String content="";
            while (bis.read(b) != -1) {
                content+=new String(b,"utf-8");
                System.out.println(content);

                bos.write(b);
            }
            bos.flush();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
