#Using ActiveRecord in Non-Web Environment

`ActiveRecordPlugin` can be used in any normal java applications independent on java web environment, which is quite handy.

Comparing with web application, only need to invoke `start()` method manually.

The demo code is shown as bellow:

```java
public class ActiveRecordTest {
  public static void main(String[] args) {
    DruidPlugin dp = new DruidPlugin("localhost", "userName", "password");
    ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
    arp.addMapping("blog", Blog.class);

    // The only difference is to invoke start() method manually.
    dp.start();
    arp.start();

    // It has already been ready to use through above simple code
    new Blog().set("title", "title").set("content", "cxt text").save();
    Blog.me.findById(123);
  }
}
```

**NOTE：**All the plugins depend on `ActiveRecordPlugin` need to invoke `start()` method manually as well, like `dp.start()` in above case.
