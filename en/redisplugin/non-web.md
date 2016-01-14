#Using RedisPluginin Non-Web Enviroment

RedisPlugin can be used in non-web enviroment as well, only need to import jfinal.jar and an extra invocation of `redisPlugin.start()`,usage is shown as bellow:


```java
    public class RedisTest {
        public static void main(String[] args) {
        RedisPlugin rp = new RedisPlugin("myRedis", "localhost");
        // The only difference with web environment is that `start()` method should be invoked.
        rp.start();
        Redis.use().set("key", "value");
        Redis.use().get("key"); }
}
```
