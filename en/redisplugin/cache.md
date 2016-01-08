#Redis与Cache

It would be very handy to Redois service by using Redis in concert with `Cache`.
Redis can get `Cache` object via `use()` method, `Cache`object provides rich APIs to use
Redis service, concrete examples are shown as bellow:

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
In above code, we get two difference `Cache` object via `bbs` and `news`,then use these two object to operate corresponding Redis servers.

Commonly we only create onw `RedisPlugin` to connect one redis server,use `Redis.use().set(key,value)`.
