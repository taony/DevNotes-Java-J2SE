package com.devnotes.j2se.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) {

        //1、文件路径分隔符，windows操作系统是："\"，Linux操作系统是："/"
        System.out.println("File.separator：" + File.separator);

        //2、文件路径分隔符，windows操作系统是：";"，Linux操作系统是：":"
        System.out.println("File.pathSeparator：" + File.pathSeparator);

        String pathRoot = FileDemo.class.getProtectionDomain().getCodeSource().getLocation().toString();
        System.out.println(pathRoot);//获取程序的根目录

        try {

            String strDir = pathRoot + "/FILES/01/";


            File dir = new File(strDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }


            if (dir.isDirectory()) {
                System.out.println("文件目录：" + dir);
            }

            //3、创建文件对象，构造函数是pathname，完整的文件路径。
            File file = new File(strDir + "file.txt");

            //4、判断文件是否存在
            if (file.exists()) {
                //5、删除文件
                file.delete();
            }

            //6、创建文件
            file.createNewFile();


            //7、文件长度
            System.out.println("文件内容长度：" + file.length());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
