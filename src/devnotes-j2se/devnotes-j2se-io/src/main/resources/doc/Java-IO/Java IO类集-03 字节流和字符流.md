# Java IO-03 字节流和字符流

## 1 InputStream 和 Reader
InputSteam和Reader是所有输入流的抽象基类，其本身并不能创建实例，而是作为所有输入流的模板。InputStream三个基本方法
- int read():从输入流读取单个字节
- int read(byte[] b)：从输入流最多读取b.length个字节的数据，并将其存储到b的数组中，返回实际读取的字节数。
- int read(byte[] b,int off,int len):从输入流读取最多len个字节的数组，并将其保存到b的数组中，放入数组时，并不是从数组的起点开始，二是从off的位置开始，返回实际读取的字节数。

Reader中也包含以下三个方法
- int read()：从输入流读取单个字符，返回所读取的字符数据。
- int read(char[] c)：从输入流最多读取c.length个字符的数据，并将其存储在字符数组c中，返回实际读取的字符数。
- int read(char[] c,int off,int len):从输入流中最对读取len个字符的数据，并将其存储在字符数组c中，放入数组c是，并不是从数组起点开始的，二是从off位置开始，返回实际读取的字符数。

> Java 7 之后改写了所有的IO资源，他们都实现了 AutoClosable 接口，因此都可以通过自动关闭资源的try语句来关闭这些 IO 流。


```
    /**
     * 读取文件
     */
    private void readFile() throws IOException {

        FileInputStream fis = null;

        try {
            //1、初始化输入流对象
            fis = new FileInputStream("C:\\Temp\\RandomAccessFileDemo.txt");

            //2、返回这个输入流中可以被读的剩下的bytes字节的估计值
            int size = fis.available();

            System.out.println("字节长度：" + size);

            //3、根据输入流的字节长度长度创建字节数组
            byte[] arr = new byte[size];

            //4、把数据读取到数组中
            fis.read(arr);

            //5、将数组中的字符转换为字符串
            String result = new String(arr);

            System.out.println(result);

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {

            //6、关闭输入流对象
            if (null != fis) {
                fis.close();
            }

        }
    }
```



## 2 OutputStream 和 Writer
Output 和 Writer 也非常相似，两个流都提供了如下三个方法：
- void write(int c); 将指定的字节/字符输出到输出流中，其中c既可以代表字节，也可以代表字符。
- void write(byte[]/char[] buf); 将字节/字符数组中的数据输出到指定的输出流中。
- void write(byte[]/char[] buf,int off,int len); 将字节/字符数组从off位置开始，长度为len的字节/字符输出到输出流中。

其中Writer还包含了一下两个方法：

- void write(String str); 将str字符串里包含的字符输出到指定的输出流中。
- void write(String str, int off, int len); 将 str 字符串从 off 的位置开始，长度为 len 的字符输出到指定输出流中。


```
    public static void write() {
        String strFilePath = String.format("C:%sTemp%swriter.txt", File.separator, File.separator);
        try {

            FileWriter writer = new FileWriter(strFilePath, true);
            writer.write(new Date().toString());

            //刷新
            writer.flush();

            //关闭文件流
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
```

