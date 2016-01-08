#Redisplugin
RedisPlugin is a plugin integrated by JFinal,so that you should configure RedisPlugin in JFinalConfig when using,the usage of configure of RedisPlugin is shown as bellow:

```java
public class DemoConfig extends JFinalConfig {
    public void configPlugin(Plugins me) {
    // 用于缓存bbs模块的redis服务
    RedisPlugin bbsRedis = new RedisPlugin("bbs", "localhost");
    me.add(bbsRedis);
    // 用于缓存news模块的redis服务
    RedisPlugin newsRedis = new RedisPlugin("news", "192.168.3.9");
    me.add(newsRedis);
} }
```
In above code, two RedisPlugin objects , bbsRedis and newRedis, were created. The `Cache` object held by first created RedisPlugin object would be the main cache object, which could be get via `Redis.use()`, otherwise need to provide parameter to get, e.g., `Redis.use("news")`.
