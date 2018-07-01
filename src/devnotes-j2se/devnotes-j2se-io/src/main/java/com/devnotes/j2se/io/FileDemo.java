package com.devnotes.j2se.io;

import java.io.File;
import java.io.IOException;

/**
 * 文件DEMO
 */
public class FileDemo {

    public static void main(String[] args) {
        create();

        delete();

        mkdir();
    }


    /**
     * 创建文件
     */
    public static void create(){

        //声明文件对象
        File file=new File("c:\\crateNewFile.txt");

        try {
            if(!file.exists()){
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
    static void delete(){
        File file=new File("c:\\crateNewFile.txt");
        file.deleteOnExit();

    }


    /**
     * 创建文件目录
     */
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
