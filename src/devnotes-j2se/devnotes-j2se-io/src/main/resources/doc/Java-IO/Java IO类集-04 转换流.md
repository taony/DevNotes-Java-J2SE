# Java IO类集-03 转换流


输入流和输出流还提供了两个转换流，这两个转换流用于实现将字节流转换为字符流。

---

InputStreamReader是将字节输入流转换为字符流，
OutputStreamWriter 将字节输出流转换为字符输出流。

## 1、InputStreamReader

```
java.lang.Object 
    java.io.Reader 
        java.io.InputStreamReader 
```

InputStreamReader是从字节流到字符流的桥：它读取字节，并使用指定的charset将其解码为字符 。 

字符集可以由名称指定，也可以被明确指定，或者可以接受平台的默认字符集。 

每个调用InputStreamReader的read（）方法之一可能会导致从底层字节输入流读取一个或多个字节。 为了使字节有效地转换为字符，可以从底层流读取比满足当前读取操作所需的更多字节。 

为了最大的效率，请考虑在BufferedReader中包装一个InputStreamReader。 例如： 

  BufferedReader in  = new BufferedReader(new InputStreamReader(System.in)); 
   
---

**代码示例：**

构造函数


```
public InputStreamReader(InputStream in)

这将创建一个使用默认字符集的输入流。

public InputStreamReader(InputStream in, String charsetName)

这将创建一个使用指定的字符集的输入流。

 public InputStreamReader(InputStream in, Charset cs)

这将创建一个使用Charset类字符编码对象的输入流。

public InputStreamReader(InputStream in, CharsetDecoder dec)

这将创建一个字符集的输入流，传入CharsetDecoder对象自动识别字符集

```


```
    public static void main(String[] args) {
        try {
            //将 System.in 对象转换为 Reader 对象
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(reader);
            String line = null;
            System.out.print("请输入内容：");
            while ((line = br.readLine()) != null) {
                if (line.equals("exit")) {
                    System.exit(1);
                }
                System.out.println("输入内容为：" + line);
            }
        } catch (Exception ex) {
        }
    }
    
```

## 2、OutputStreamWriter

OutputStreamWriter 类OutputStreamWriter是字符的桥梁流以字节流：向其写入的字符编码成使用指定的字节charset 。它使用的字符集可以由名称指定，也可以被明确指定，或者可以接受平台的默认字符集。 每次调用write（）方法都会使编码转换器在给定字符上被调用。 所得到的字节在写入底层输出流之前累积在缓冲区中。 可以指定此缓冲区的大小，但是默认情况下它大部分用于大多数目的。 请注意，传递给write（）方法的字符不会缓冲。 
为了最大的效率，请考虑在BufferedWriter中包装一个OutputStreamWriter，以避免频繁的转换器调用。 例如： 


```
java.lang.Object 
    java.io.Writer 
        java.io.OutputStreamWriter 
```



```



```
