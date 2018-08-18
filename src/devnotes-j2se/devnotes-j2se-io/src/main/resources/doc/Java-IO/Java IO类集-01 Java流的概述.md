# Java IO-01 Java流的概述

## 1 Java IO的概念
    
Java IO 流是实现输入/输出的基础，它方便的实现数据的输入/输出操作，把 Java 中不同的输入/输出源（键盘、文件、网络连接等）抽象表述为“流”（ Stream ），通过流的方式允许 Java 程序使用相同的方式来访问不同的输入/输出源。Stream 是从起源（ Source ）到接收（ Sink ）的有序数据。

Java 把所有传统的流类型（类或者抽象类）都放在 java.io 包中，用以实现输入/输出功能。

## 2 流的分类

### 2.1 输入流和输出流
按照输入流的流向分为，分为输入流和输出流。
- 输入流：只能从中读取数据，而不能向其写入数据。
- 输出流：只能向其写入数据，而不能从中读取数据。
> 输入流的基类是 InputStream 和 Reader ，输出流的基类是 OutputStream 和 Writer。

### 2.2 字符流和字节流
字节流和字符流的用法相同，区别在于字节流和字符流所操作的数据单元不同，字节流是操作8位字节(byte) 的数据单元，二字符流操作的是16位(char)的字符数据单元。

### 2.3 节点流和处理流
- 节点流：可以从/向一个特定的IO设备（如磁盘、网络）读/写数据的流，成为节点流。也称为低级流（Low Level Stream），使用节点流的时候，程序直接访问实际的数据源。
- 处理流：用于对一个已经存在的流进行连接或封装，通过封装后的流实现数据的读写功能，处理流也被称为高级流。
> Java使用处理流来包装节点流的方式，是装饰者模式，通过使用处理流来包装不同的节点流，既可以消除不同节点流的实现差异，也可以提供更方便的方法来完成输入/输出功能。处理流也被称为包装流。

## 3 输入/输出流体系

分类 | 字节输入流 | 字节输出流 | 字符输入流 | 字符输出流
---|---|---|---|---
抽象基类| *InputStream*| *OutputStream* | *Reader* | *Writer*
访问文件| FileInputStream |FileOutputStream| FileReader | FileWriter
访问数组| ByteArrayInputStream|ByteOutputStream| CharArrayReader|CharArrayWriter
访问管道|PipedInputStream|PipedOutputStream|PipedReader|PipedWriter
访问字符串|  |  |StringReader|StringWriter
缓冲流|BufferedInputStream|BufferedOutputStream|BufferedReader|BufferedWriter
转换流| | |InputSteamReader|OutputStreamWriter
对象流|ObjectInputSteam|ObjectOutputStream||
抽象基类|*FilterInputStream*|*FilterOutputStream*|*FilterReader*|*FilterWriter*
打印流||PrintStream||
推回输出流|PushbackInputStream||PushbackReader|
特殊流|DataInputStream|DataOutputStream||

