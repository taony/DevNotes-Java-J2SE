# Java IO类集-10 对象流


## 1、对象序列化的意义
对象序列化的目标是将对象保存到磁盘中，或允许在网络中直接传输对象。对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许将这种二进制流持久地保存在磁盘上，通过网络传输到另一个网络节点。其他程序获取到这种二进制流，都可以讲这种二进制流恢复成原来的对象。

对象序列化（Serialize）指讲一个Java对象写入IO流中，于此对应的是，对象的反序列化（Deserialize）则指从IO流中恢复该Java对象。

如果让某个对象支持序列化机制，则必须让它的类是可序列化的，该类必须实现如下两个接口之一：Serialiable、Externalizable

## 2、对象序列化

### 2.1、声明可序列化对象

**（1）serialVersionUID**

serialVersionUID适用于Java的序列化机制。Java的序列化机制是通过判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体类的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常，即是InvalidCastException。

**（2）transient关键词**

```
class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private           String  userName;
    private           String  userPwd;
    private transient Integer age;

    //序列化对象不需要提供默认构造器，序列化时不需要依赖于默认构造器
    public User(String name, String pwd, int age) {
        this.userName = name;
        this.userPwd = pwd;
        this.age = age;
    }

    /**
     * 自定义序列化方法
     * @param os
     * @throws Exception
     */
    private void writeObject(ObjectOutputStream os) throws Exception{
        os.defaultWriteObject();
    }

    /**
     * 自定义反序列化方法
     * @param is
     * @throws Exception
     */
    private void readOjbect(ObjectInputStream is) throws Exception {
        is.defaultReadObject();
    }

}

```

### 2.2、对象序列化

（1）简单序列化示例

```
  public static void main(String[] args) throws Exception {

        outputObject();

    }

    public static void outputObject() throws Exception {

        User user = new User("zhangsan", "123456", 5);

        File file = new File(FileTestUtil.getTempDir() + "ObjectOutputStream.txt");

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

        outputStream.writeObject(user);

        outputStream.close();

    }
```

（2）transient

### 2.2、对象反序列化

```
public static void main(String[] args) throws Exception {

        File file = new File(FileTestUtil.getTempDir() + "ObjectOutputStream.txt");

        FileInputStream fis = new FileInputStream(file);

        ObjectInputStream ois = new ObjectInputStream(fis);

        User user = (User) ois.readObject();

        System.out.println(user);

        ois.close();
    }

```


### 2.3、序列化对象


### 2.3、Java9 序列化过滤功能
