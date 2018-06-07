package com.devnotes.j2se.io.inputstreamdemo;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.InputStream;

public class InputStreamDemo {

    public static void main(String[] args) {

        InputStream is=new ByteInputStream();
        Object obj=System.in;
        System.out.println(obj);

    }
}
