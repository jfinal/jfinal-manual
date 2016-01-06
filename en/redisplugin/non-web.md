#非web环境使用redisplugin

RedisPlugin 也可以在非 web 环境下使用,只需引入 jfinal.jar 然后多调用一下 redisPlugin.start()即可,以下是代码示例:

```java
    public class RedisTest {
        public static void main(String[] args) {
        RedisPlugin rp = new RedisPlugin("myRedis", "localhost");
        // 与web下唯一区别是需要这里调用一次start()方法
        rp.start();
        Redis.use().set("key", "value");
        Redis.use().get("key"); }
}
```
