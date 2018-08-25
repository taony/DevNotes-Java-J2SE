package com.devnotes.j2se.io;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {

    public static void main(String[] args) {

        try {
            //System.err 在控制台输出是红色的字体
            OutputStream os = System.err;
            OutputStreamWriter osw = new OutputStreamWriter(os);
            osw.write("OutputStreamWriterDemo");
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
