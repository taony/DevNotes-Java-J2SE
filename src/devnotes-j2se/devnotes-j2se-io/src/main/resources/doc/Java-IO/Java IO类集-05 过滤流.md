# Java IO类集-05 过滤流

## 1、FilterReader

FilterReader类集关系。

```
java.lang.Object 
    java.io.Reader 
        java.io.FilterReader 
```
FilterReader是一个抽象类、只简单重写了父类Reader的一些方法、作用是为所有装饰类提供一个标准。子类要重写父类的核心方法和扩展具有自己特色的方法。目前没有子类、作用是为以后的扩展提供一个接口。
 
```
public abstract class FilterReader extends Reader
```



## 2、FilterWriter

## 3、FilterInputStream

## 4、FilterOutputStream