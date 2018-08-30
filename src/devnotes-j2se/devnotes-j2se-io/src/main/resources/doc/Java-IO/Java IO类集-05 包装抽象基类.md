# Java IO类集-05 抽象基类

Java IO 抽象基类包括FilterReader、FilterWriter、FilterInputStream、FilterOutputStream，其作用主要Reader、Writer、InputStream、OutputStream的包装类。

## 1、FilterReader

### 1.1、FilterReader声明

FilterReader是一个抽象类、只简单重写了父类Reader的一些方法、作用是为所有装饰类提供一个标准。子类要重写父类的核心方法和扩展具有自己特色的方法。目前没有子类、作用是为以后的扩展提供一个接口。
 
 
```
// 类结构
java.lang.Object 
    java.io.Reader 
        java.io.FilterReader 

// 类声明
public abstract class FilterReader extends Reader
```
### 1.2、源码解读
```
package java.io;
 
public abstract class FilterReader extends Reader {
 
    //内置了一个Reader对象句柄in，用于接收传入的Reader对象。
    protected Reader in;
 
    /**
     * 带一个参数的构造方法，传入的参数类型为一个Reader对象。内部直接调用父类Reader对象的对应构造方法，并为内置的Reader对象句柄in赋值。
     */
    protected FilterReader(Reader in) {
        super(in);
        this.in = in;
    }
 
    /**
     * 该方法每次读取读取一个字符的数据，实质就是调用Reader中对应的read方法。
     */
    public int read() throws IOException {
        return in.read();
    }
 
    /**
     * 该方法每次能够读取多个字符的数据，包含三个参数，第一个参数为一个字符数组，用于存放读取的数据内容，第二和第三个参数都是一个int型数值，分别表示着
     * 在数组中存放数据的起点以及存储数据的长度。内部实质直接调用Reader中对应的read方法。
     */
    public int read(char cbuf[], int off, int len) throws IOException {
        return in.read(cbuf, off, len);
    }
 
    /**
     * 该方法可以跳过指定字符数量的数据。内部实质直接调用Reader中对应的read方法。
     */
    public long skip(long n) throws IOException {
        return in.skip(n);
    }
 
    /**
     * 该方法用于判断当前流是否处于可读状态
     */
    public boolean ready() throws IOException {
        return in.ready();
    }
 
    /**
     * 该方法用于判断当前流是否支持流标记功能。
     */
    public boolean markSupported() {
        return in.markSupported();
    }
 
    /**
     * 该方法用于在指定位置留下标记，以便于跟reset方法联合使用，从而可以使流回退到标记的地方。内部实质是直接调用Reader的mark方法。
     */
    public void mark(int readAheadLimit) throws IOException {
        in.mark(readAheadLimit);
    }
 
    /**
     * 该方法用于与mark方法联用，用于将当前流的读取位置回退到标记的地方。内部实质是直接调用Reader的reset方法。
     */
    public void reset() throws IOException {
        in.reset();
    }
 
    
    /**
     * 该方法用于关闭当前的流及与之相关联的系统资源。内部实质是直接调用Reader对应的close方法。
     */
    public void close() throws IOException {
        in.close();
    }
}

```


## 2、FilterWriter

### 2.1、类声明

```
// 类结构
java.lang.Object 
    java.io.Writer 
        java.io.FilterWriter 

// 类声明
public abstract class FilterWriter extends Writer
```

### 2.2、FilterWriter 源码解读

```
package java.io;
 
 
public abstract class FilterWriter extends Writer {
 
    //内置了一个Writer对象的句柄，用于接收传入的Writer对象。
    protected Writer out;
 
    /**
     * 一个带一个参数的构造方法，传入的参数是一个Writer对象。内部实质上是调用Writer对应的构造方法，并为内置的Writer对象句柄赋值。
     */
    protected FilterWriter(Writer out) {
        super(out);
        this.out = out;
    }
 
    /**
     * 该方法可以每次写入一个字符的数据，传入的参数为要写入字符数据的int型值。内部实质是调用Writer对应的构造方法。
     */
    public void write(int c) throws IOException {
        out.write(c);
    }
 
    /**
     * 该方法可以每次写入多个字符的数据，含有3个参数，第一个参数为一个字符型数组，其中包含要写入的数据，第二和第三个参数都是一个int型数值
     * 分别表示了从数组中取出数据的起点和长度。内部本质是直接调用Writer对应的write方法。
     */
    public void write(char cbuf[], int off, int len) throws IOException {
        out.write(cbuf, off, len);
    }
 
    /**
     * 该方法可以每次写入一个字符串类型的数据（可以截取一部分），含有3个参数，第一个参数为要写入的字符串类型的数据，第二和第三个参数都是
     * 一个int型数据，分别代表截取字符串数据的起点和终点。内部本质上是直接调用Writer对应的write方法。
     */
    public void write(String str, int off, int len) throws IOException {
        out.write(str, off, len);
    }
 
    /**
     * 该方法用于将缓存中的数据强制写出。内部实质上是调用Writer的flush方法。
     */
    public void flush() throws IOException {
        out.flush();
    }
 
    /**
     * 该方法用于关闭当前流以及其相关联的系统资源。内部实质上是调用Writer的close方法。
     */
    public void close() throws IOException {
        out.close();
    }
 
}

```


## 3、FilterInputStream
### 3.1、FilterInputStream 声明


```
// 类结构
java.lang.Object 
    java.io.OutputStream 
        java.io.FilterOutputStream 

// 类定义声明
public class FilterOutputStream extends OutputStream

// 已实现接口:  
Closeable ， Flushable ， AutoCloseable 

// 已知直接子类： 
BufferedInputStream ， CheckedInputStream ， CipherInputStream ， DataInputStream ， DeflaterInputStream ， DigestInputStream ， InflaterInputStream ， LineNumberInputStream ， ProgressMonitorInputStream ， PushbackInputStream 
```


### 3.2、FilterInputStream 源码


```
package java.io;
 
public class FilterInputStream extends InputStream {
    /**
     * 内部声明了一个InputStream对象的句柄，用于接收传入的InputStream对象。同时用volatile关键字修饰，确保了数据改变时的可见性。
     */
    protected volatile InputStream in;
 
    /**
     * 一个被protected关键字修饰的构造汉方，含义一个参数，参数类型为InputStream类型，将传入的InputStream对象赋值给声明的句柄in。
     */
    protected FilterInputStream(InputStream in) {
        this.in = in;
    }
 
    /**
     * 定义了一个不带参的read方法，只是简单的调用了InputStream的read方法，每次读取一个字节的数据，用于读取流中数据。
     */
    public int read() throws IOException {
        return in.read();
    }
 
    /**
     * 定义了一个带一个参数的read方法，内部实际上是调用了InputStream对应的read方法，每次可以通过传入的字节数组作为缓存区读取一片数据。
     */
    public int read(byte b[]) throws IOException {
        return read(b, 0, b.length);
    }
 
    /**
     * 定义了一个带三个参数的read方法，内部实际上是调用了InputStream对应的read方法。可以通过传入的数组作为缓存，另外两个参数控制的是从缓存中读取的位置以
     * 及长度，每次可以读取一片数据。
     */
    public int read(byte b[], int off, int len) throws IOException {
        return in.read(b, off, len);
    }
 
    /**
     * 定义了一个带一个参数的skip方法，内部实质是调用InputStream中的skip方法。用于跳过指定长度的数据，进行数据读取。
     */
    public long skip(long n) throws IOException {
        return in.skip(n);
    }
 
    /**
     * 定义了一个available方法，内部实质是调用了InputStream的available方法，用于获取流中仍可以读取字节数。
     */
    public int available() throws IOException {
        return in.available();
    }
 
    /**
     * 定义了一个close方法，内部实质是调用了InputStream的close方法，用于关闭流。
     */
    public void close() throws IOException {
        in.close();
    }
 
    /**
     * 定义了一个mark方法，内部实质是调用了InputStream的mark方法，用于在流中留下标记，与reset方法联合使用，可以回到标记处继续读取数据。
     */
    public synchronized void mark(int readlimit) {
        in.mark(readlimit);
    }
 
    /**
     * 定义了一个reset方法，内部实质是调用了InputStream的reset方法，与mark方法联合使用，可以回到标记的地方继续读取数据。
     */
    public synchronized void reset() throws IOException {
        in.reset();
    }
 
    /**
     * 定义了一个markSupported方法，内部实质是调用了InputStream的markSupported方法，返回的boolean值表示当前流是否支持标记功能。
     */
    public boolean markSupported() {
        return in.markSupported();
    }
}

```


## 4、FilterOutputStream

### 4.1、FilterOutputStream 类声明


```
// 类结构
java.lang.Object 
    java.io.OutputStream 
        java.io.FilterOutputStream 

// 类定义声明
public class FilterOutputStream extends OutputStream


// 已实现接口: 
Closeable ， Flushable ， AutoCloseable 

// 已知直接子类： 
BufferedOutputStream ， CheckedOutputStream ， CipherOutputStream ， DataOutputStream ， DeflaterOutputStream ， DigestOutputStream ， InflaterOutputStream ， PrintStream 
```


### 4.2、FilterOutputStream 源码解读


```
package java.io;
 
public class FilterOutputStream extends OutputStream {
    /**
     * 内部声明了一个OutputStream对象的句柄，用于接收传入的OutputStream对象。
     */
    protected OutputStream out;
 
    /**
     * 一个带一个参数的构造函数，参数为一个OutputStream对象，将传入的OutputStream对象赋值给声明的句柄out。
     */
    public FilterOutputStream(OutputStream out) {
        this.out = out;
    }
 
    /**
     * 定义了一个write方法，内部实质调用的是OutputStream对象的write方法，每次写人一个字节。
     */
    public void write(int b) throws IOException {
        out.write(b);
    }
 
    /**
     * 定义了一个带一个参数的write方法，参数类型为一个byte类型数组，内部实质上调用了OutputStream对象的write方法。
     */
    public void write(byte b[]) throws IOException {
        write(b, 0, b.length);
    }
 
    /**
     * 内部实质上调用的OutputStream的write方法，一次可以写入一段数据。
     */
    public void write(byte b[], int off, int len) throws IOException {
        if ((off | len | (b.length - (len + off)) | (off + len)) < 0)
            throw new IndexOutOfBoundsException();
 
        for (int i = 0 ; i < len ; i++) {
            write(b[off + i]);
        }
    }
 
    /**
     * 定义了一个flush方法，内部实质上是调用了OutputStream对象的flush方法，保证数据已从缓存写入到目的地。
     */
    public void flush() throws IOException {
        out.flush();
    }
 
    /**
     * 使用了try-resource的方式关闭流，同时调用flush方法，确保数据已经写出。
     */
    @SuppressWarnings("try")
    public void close() throws IOException {
        try (OutputStream ostream = out) {
            flush();
        }
    }
}

```
