package com.devnotes.j2se.io;

import java.io.*;

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

            demo.readFileWithBuffer2();

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

            System.out.println("字节长度：" + size);

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

    private void readFileWithBuffer() {

        File file = new File("C:\\Temp\\RandomAccessFileDemo.txt");

        String content = "";
        try {
            FileInputStream fis = new FileInputStream(file);

            int size = 0;

            byte[] buffer = new byte[1024];

            while ((size = fis.read(buffer)) != -1) {
                content = new String(buffer, 0, size,"utf-8");

                //中文乱码
                System.out.println(content);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void readFileWithBuffer2() {

        File file = new File("C:\\Temp\\RandomAccessFileDemo.txt");

        String content = "";
        try {
            FileInputStream fis = new FileInputStream(file);

            InputStreamReader reader=new InputStreamReader(fis,"GBK");

            BufferedReader br=new BufferedReader(reader);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
