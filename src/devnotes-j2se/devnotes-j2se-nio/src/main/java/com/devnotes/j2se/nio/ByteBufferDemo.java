package com.devnotes.j2se.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 *
 */
public class ByteBufferDemo {

    public static void main(String[] args) throws Exception{
        RandomAccessFile raf=new RandomAccessFile(FileTestUtil.getTempDir()+"ByteBufferDemo.txt","rw");
        FileChannel channel=raf.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(48);
        while (channel.read(byteBuffer)>0){
            byteBuffer.flip();
            System.out.println(getString(byteBuffer));
            byteBuffer.clear();
        }
    }

    /**
     * 将ByteBuffer转换为String字符串
     *
     * @param byteBuffer
     * @return
     * @throws Exception
     */
    public static String getString(ByteBuffer byteBuffer) throws Exception{
        Charset charset=Charset.forName("UTF-8");
        CharsetDecoder decoder=charset.newDecoder();
        CharBuffer charBuffer=decoder.decode( byteBuffer.asReadOnlyBuffer());
        return charBuffer.toString();
    }
}
