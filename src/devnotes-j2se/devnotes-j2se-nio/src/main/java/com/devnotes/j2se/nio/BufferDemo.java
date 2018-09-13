package com.devnotes.j2se.nio;

import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;

public class BufferDemo {

    public static void main(String[] args) throws Exception {

        Channel channel = new FileInputStream("").getChannel();

        ByteBuffer byteBuffer= new Buffer(5);

    }

}
