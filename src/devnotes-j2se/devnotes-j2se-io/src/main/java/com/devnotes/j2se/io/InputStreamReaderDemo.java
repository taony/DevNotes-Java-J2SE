package com.devnotes.j2se.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {

    public static void main(String[] args) {

        try (
                //将 System.in 对象转换为 Reader 对象
                InputStreamReader reader = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(reader))
        {



        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
