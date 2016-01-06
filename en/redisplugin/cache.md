#Redis与Cache

Redis 与 Cache 联合起来可以非常方便地使用 Redis 服务,Redis 对象通过 use()方法来获取
到 Cache 对象,Cache 对象提供了丰富的 API 用于使用 Redis 服务,下面是具体使用示例:

```java
public void redisDemo() {
// 获取名称为bbs的Redis Cache对象
    Cache bbsCache = Redis.use("bbs");
    bbsCache.set("key", "value");
    bbsCache.get("key");
    // 获取名称为news的Redis Cache对象
    Cache newsCache = Redis.use("news");
    newsCache.set("k", "v");
    newsCache.get("k");
    // 最先创建的Cache将成为主Cache,所以可以省去cacheName参数来获取
    bbsCache = Redis.use(); // 主缓存可以省去cacheName参数
    bbsCache.set("jfinal", "awesome");
}
```
以上代码中通过”bbs”、”news”做为 use 方法的参数分别获取到了两个 Cache 对象,使用这 两个对象即可操作其所对应的 Redis 服务端。
通常情况下只会创建一个 RedisPlugin 连接一个 redis 服务端,使用 Redis.use().set(key,value) 即可。
