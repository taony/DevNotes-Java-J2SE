package com.devnotes.j2se.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: taony
 * @email:taonyzhang@gmail.com
 * @description: 读取文件数据内容
 * @date: Created in 1:10 2018/6/28
 */
public class FileInputStreamDemo {


    public static void main(String[] args) {

        FileInputStreamDemo demo = new FileInputStreamDemo();

        try {
            demo.readFile();
        } catch (Exception e) {

        }
    }

    /**
     * 读取文件
     */
    private void readFile() throws IOException {

        FileInputStream fis = null;

        try {
            //1、初始化输入流对象
            fis = new FileInputStream("C:\\Temp\\RandomAccessFileDemo.txt");

            //2、返回这个输入流中可以被读的剩下的bytes字节的估计值
            int size = fis.available();

            System.out.println(size);

            //3、根据输入流的字节长度长度创建字节数组
            byte[] arr = new byte[size];

            //4、把数据读取到数组中
            fis.read(arr);

            //5、将数组中的字符转换为字符串
            String result = new String(arr);

            System.out.println(result);

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {

            //6、关闭输入流对象
            if (null != fis) {
                fis.close();
            }

        }
    }
}
