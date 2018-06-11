package com.devnotes.j2se.io.files;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) {
        create();

        delete();

        mkdir();
    }

    static void create(){

        //声明文件对象
        File file=new File("c:\\crateNewFile.txt");
        try {
            //创建文件
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void delete(){
        File file=new File("c:\\crateNewFile.txt");
        file.deleteOnExit();

    }


    static void mkdir(){
        File file=new File("c:"+File.separator+"/temp/");
        file.mkdir();
    }


    static void mkdirs(){
        File file=new File("c"+File.separator+"/temp/01/01/");
        file.mkdirs();
    }

    static void list(){
        File file=new File("c:"+File.separator);
        File[] files=file.listFiles();

      for (File f :files){
          System.out.println(f);

      }
    }


}
