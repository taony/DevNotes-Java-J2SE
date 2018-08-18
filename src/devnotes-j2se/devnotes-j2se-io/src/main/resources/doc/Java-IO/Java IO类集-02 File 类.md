# Java IO-02 File 类

> File 类是 java.io 包下代表与平台无关的文件和目录，实现平台上操作文件和目录。如果需要操作文件和目录，都可以使用File类进行操作。但是，如果需要访问文件本身，则需要使用输入流/输出流。

## 1 访问文件和录

### 1.1 文件名称记录目录访问

```
    /**
     * 1.1 获取文件名相关的操作
     */
    public static void getFileNameMethods() {

        //文件对象
        String strFilePath = "C:" + File.separator + "temp" + File.separator + "file.txt";
        File file = new File(strFilePath);

        //获取文件名
        String fileName = file.getName();
        System.out.println("文件名：" + fileName);

        String filePath = file.getPath();
        System.out.println("文件对应的路径名：" + filePath);

        File fileAbsolute = file.getAbsoluteFile();
        System.out.println("文件对象的绝对路径：" + fileAbsolute);

        String fileAbsolutePath = file.getAbsolutePath();
        System.out.println("文件相对路径名称：" + fileAbsolutePath);

        String fileParent = file.getParent();
        System.out.println("文件父路径名称：" + fileParent);

        boolean renamed = file.renameTo(new File("C:\\temp\\ newfile.txt"));
        System.out.println("文件重命名是否成功：" + renamed);

    }
        
```

### 1.2 文件检测相关方法


```
    /**
     * 1.2 文件对象检测相关方法
     */
    public static void checkFiles() {

        String strFilePath = "C:" + File.separator + "temp" + File.separator + "file.txt";
        File file = new File(strFilePath);

        //检测文件是否存在
        boolean exists = file.exists();
        System.out.println("文件或者目录是否存在：" + exists);

        boolean canWrite = file.canWrite();
        System.out.println("File对象是否可写入：" + canWrite);

        boolean canRead = file.canRead();
        System.out.println("File对象是否可读：" + canRead);

        boolean isFile = file.isFile();
        System.out.println("判断File对象是否是文件：" + isFile);

        boolean isDirectory = file.isDirectory();
        System.out.println("判断File对象是否是目录：" + isDirectory);

        boolean isAbsolute = file.isAbsolute();
        System.out.println("File对象对应的文件或目录是否是绝对路径：" + isAbsolute);

    }

```

### 1.3 获取文件信息

```
 public static void getFileInfo() {
        String strFilePath = "C:" + File.separator + "temp" + File.separator + "file.txt";
        File file = new File(strFilePath);

        long len = file.length();
        System.out.println("文件内容长度：" + len);

        long lastModified = file.lastModified();
        System.out.println("文件最后修改时间：" + lastModified);
    }
    
```
### 1.4 文件操作相关方法


```
    /**
     * 1.4 文件操作相关方法
     */
    public static void fileMethods() {

        String strFilePath = "C:" + File.separator 
        + "temp" + File.separator + "file" + new Random().nextInt(100) + ".txt";

        System.out.println(strFilePath);

        File file = new File(strFilePath);

        try {

            // 判断文件是否存在，如果不存在，则新增
            if (!file.exists()) {
                file.createNewFile();
            }


            //删除文件
            file.delete();

            //创建临时文件，预定义参数是临时文件的前缀和后缀
            File fileTemp = File.createTempFile("temp", ".fs");
            System.out.println(fileTemp.getCanonicalPath());
            //当虚拟机退出时，删除临时文件
            fileTemp.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
```

### 1.5 目录操作相关方法

```
    /**
     * 1.5 目录操作相关方法
     */
    public static void dirMethods() {
        File file = new File(".");

        //创建文件目录
        file.mkdir();

        //列出File对象所有子文件名和路径名，返回字符串数组
        String[] strNames = file.list();

        //列出File所有的子文件和路径，返回File数组
        File[] files = file.listFiles();

        //列出系统所有的根路径
        files = File.listRoots();


    }
```



## 2 文件过滤器


```
import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterDemo {

    public static void main(String[] args) {

        listFiles();

        listFile2();

    }

    static void listFiles() {

        File file = new File("D:\\");

        //需要厂家一个过滤实现类
        MyFilter filter = new MyFilter("ec");

        String[] names = file.list(filter);

        for (String name : names) {
            System.out.println(name);
        }
    }

    static void listFile2() {
        File file = new File("D:\\");

        //lambda表达式
        String[] names = file.list((dir, name) -> dir.isFile() || name.contains("es"));

        for (String name : names) {
            System.out.println(name);
        }
    }


    /**
     * 声明一个文件
     */
    static class MyFilter implements FilenameFilter {

        private String type;

        public MyFilter(String type) {
            this.type = type;
        }

        @Override
        public boolean accept(File dir, String name) {

            return dir.isFile() && name.contains(type);
        }
    }
```
