package com.devnotes.j2se.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {

    public static void main(String[] args) {

        try (
                //将 System.in 对象转换为 Reader 对象
                InputStreamReader reader = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(reader)) {

            String line = null;

            while ((line = br.readLine()) != null) {
                if (line.equals("exit")) {
                    System.exit(1);
                }
                System.out.println("输入内容为：" + line);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
