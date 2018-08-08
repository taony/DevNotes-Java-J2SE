package com.devnotes.j2se.io;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterDemo {

    public static void main(String[] args) {

        listFiles();

        listFile2();

    }

    static void listFiles() {

        File file = new File("D:\\");

        //需要创建一个过滤实现类
        MyFilter filter = new MyFilter("ec");

        String[] names = file.list(filter);

        for (String name : names) {
            System.out.println(name);
        }
    }

    static void listFile2() {
        File file = new File("D:\\");

        //lambda表达式
        String[] names = file.list((dir, name) -> dir.isFile() || name.contains("es"));

        for (String name : names) {
            System.out.println(name);
        }
    }


    /**
     * 声明一个文件
     */
    static class MyFilter implements FilenameFilter {

        private String type;

        public MyFilter(String type) {
            this.type = type;
        }

        @Override
        public boolean accept(File dir, String name) {

            return dir.isFile() && name.contains(type);
        }
    }
}
