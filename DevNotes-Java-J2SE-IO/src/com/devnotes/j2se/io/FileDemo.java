package com.devnotes.j2se.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) {

        //1、文件路径分隔符，windows操作系统是："\"，Linux操作系统是："/"
        System.out.println("File.separator：" + File.separator);

        //2、文件路径分隔符，windows操作系统是：";"，Linux操作系统是：":"
        System.out.println("File.pathSeparator：" + File.pathSeparator);

        try {

            //3、创建文件对象，构造函数是pathname，完整的文件路径。
            File file = new File("text.txt");

            //4、判断文件是否存在
            if (file.exists()) {

                //5、删除文件
                file.delete();
            }

            //6、创建文件
            file.createNewFile();

            file.isDirectory();

            //7、文件长度
            System.out.println(file.length());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
