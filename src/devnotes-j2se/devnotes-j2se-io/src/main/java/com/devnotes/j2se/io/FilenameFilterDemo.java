package com.devnotes.j2se.io;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterDemo {

    public static void main(String[] args) {
        File file = new File("D:\\");

        MyFilter filter = new MyFilter("ec");

        String[] names = file.list(filter);

        for (String name : names) {
            System.out.println(name);
        }


        String[] fileNames=file.list((dir,name)->name.contains("ec") && dir.isFile());

        System.out.println(fileNames);

    }

    /**
     *  声明一个文件
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
