package com.devnotes.j2se.io;

import java.io.File;
import java.io.IOException;

/**
 * 文件DEMO
 */
public class FileDemo {

    public static void main(String[] args) {

        getFileNameMethods();
    }

    /**
     * 一、获取文件名相关的操作
     */
    public static void getFileNameMethods() {

        //文件对象
        String strFilePath = "C:" + File.separator + "temp" + File.separator + "file.txt";
        File file = new File(strFilePath);

        //获取文件名
        String fileName = file.getName();
        System.out.println("文件名：" + fileName);

        String filePath = file.getPath();
        System.out.println("文件对应的路径名：" + filePath);

        File fileAbsolute = file.getAbsoluteFile();
        System.out.println("文件对象的绝对路径：" + fileAbsolute);

        String fileAbsolutePath = file.getAbsolutePath();
        System.out.println("文件相对路径名称：" + fileAbsolutePath);

        String fileParent = file.getParent();
        System.out.println("文件父路径名称：" + fileParent);

        boolean renamed = file.renameTo(new File("C:\\temp\\ newfile.txt"));
        System.out.println("文件重命名是否成功：" + renamed);

    }

    /**
     * 二、文件对象检测相关方法
     */
    public static void checkFiles() {

        String strFilePath = "C:" + File.separator + "temp" + File.separator + "file.txt";
        File file = new File(strFilePath);

        //检测文件是否存在
        boolean exists = file.exists();
        System.out.println("文件或者目录是否存在：" + exists);

        boolean canWrite = file.canWrite();
        System.out.println("文件是否可写入：" + canWrite);

        boolean canRead = file.canRead();
        System.out.println("文件是否可读：" + canRead);

        boolean isFile = file.isFile();
        System.out.println("判断File对象是否是文件：" + isFile);

        boolean isDirectory = file.isDirectory();
        System.out.println("判断File对象是否是目录：" + isDirectory);

    }

    public static void listFileNames() {
        File file = new File(".");

        String[] arrFileNames = file.list();

        if (null != arrFileNames && arrFileNames.length > 0) {
            for (String fileName : arrFileNames) {
                System.out.println(fileName);
            }
        }
    }

    public static void listFiles(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        if (null != files && files.length > 0) {
            for (File f : files) {
                if (f.isDirectory()) {
                    System.out.println("文件目录：" + f.getPath());
                    listFiles(f.getPath());
                } else {
                    System.out.println("文件：" + f.getName());
                }
            }
        }
    }


    /**
     * 创建文件
     */
    public static void create() {

        //声明文件对象
        File file = new File("c:\\crateNewFile.txt");

        try {
            if (!file.exists()) {
                //创建文件
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     */
    static void delete() {
        File file = new File("c:\\crateNewFile.txt");
        file.deleteOnExit();

    }


    /**
     * 创建文件目录
     */
    static void mkdir() {
        File file = new File("c:" + File.separator + "/temp/");
        file.mkdir();
    }


    static void mkdirs() {
        File file = new File("c" + File.separator + "/temp/01/01/");
        file.mkdirs();
    }

    static void list() {
        File file = new File("c:" + File.separator);
        File[] files = file.listFiles();

        for (File f : files) {
            System.out.println(f);

        }
    }


}
