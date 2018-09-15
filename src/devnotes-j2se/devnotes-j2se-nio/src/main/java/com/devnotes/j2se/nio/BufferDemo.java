package com.devnotes.j2se.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class BufferDemo {

    public static void main(String[] args) throws Exception {

        File        file       = new File(FileTestUtil.getTempDir() + "BufferDemo.txt");
        FileChannel channel    = new FileInputStream(file).getChannel();
        ByteBuffer  byteBuffer = ByteBuffer.allocate(128);

        Charset        charset        = Charset.forName("UTF-8");
        CharsetDecoder charsetDecoder = charset.newDecoder();
        CharBuffer     charBuffer     = null;

        while (channel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            charBuffer = charsetDecoder.decode(byteBuffer.asReadOnlyBuffer());
            System.out.println(charBuffer.toString());
            byteBuffer.clear();
        }

    }

}
