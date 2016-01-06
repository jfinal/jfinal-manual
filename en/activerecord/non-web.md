#非web环境下使用ActiveRecord

ActiveRecordPlugin可以独立于java web 环境运行在任何普通的java程序中，使用方式极度简单，相对于web项目只需要手动调用一下其start() 方法即可立即使用。以下是代码示例：

```java
public class ActiveRecordTest {
  public static void main(String[] args) {
    DruidPlugin dp = new DruidPlugin("localhost", "userName", "password");
    ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
    arp.addMapping("blog", Blog.class);

    // 与web环境唯一的不同是要手动调用一次相关插件的start()方法
    dp.start();
    arp.start();

    // 通过上面简单的几行代码，即可立即开始使用
    new Blog().set("title", "title").set("content", "cxt text").save();
    Blog.me.findById(123);
  }
}
```

**注意：**ActiveRecordPlugin所依赖的其它插件也必须手动调用一下start()方法，如上例中的dp.start()。
