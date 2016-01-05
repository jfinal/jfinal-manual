#Redisplugin

RedisPlugin 是作为 JFinal 的 Plugin 而存在的,所以使用时需要在 JFinalConfig 中配置 RedisPlugin,以下是 RedisPlugin 配置示例代码:

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

以上代码创建了两个 RedisPlugin 对象,分别为 bbsRedis 和 newsRedis。最先创建的 RedisPlugin 对象所持有的 Cache 对象将成为主缓存对象,主缓存对象可通过 Redis.use()直接获 取,否则需要提供 cacheName 参数才能获取,例如:Redis.use(“news”)
