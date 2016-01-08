#Using RedisPluginin Non-Web Enviroment

RedisPlugin can be used in non-web enviroment as well, only need to import jfinal.jar and an extra invocation of `redisPlugin.start()`,usage is shown as bellow:


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
