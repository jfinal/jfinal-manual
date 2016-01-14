#Redis与Cache

It would be very handy to Redois service by using Redis in concert with `Cache`.
Redis can get `Cache` object via `use()` method, `Cache`object provides rich APIs to use
Redis service, concrete examples are shown as bellow:

```java
public void redisDemo() {
    // Retrive the Redis Cache object named bbs.
    Cache bbsCache = Redis.use("bbs");
    bbsCache.set("key", "value");
    bbsCache.get("key");
    // Retrive the Redis Cache object named news.
    Cache newsCache = Redis.use("news");
    newsCache.set("k", "v");
    newsCache.get("k");
    //The Cache created firstly would be the main Cache, so that it could be retrived without cacheName.
    bbsCache = Redis.use(); //  The cacheName of main Cache could be omitted.
    bbsCache.set("jfinal", "awesome");
}
```
In above code, we get two difference `Cache` object via `bbs` and `news`,then use these two object to operate corresponding Redis servers.

Commonly we only create onw `RedisPlugin` to connect one redis server,use `Redis.use().set(key,value)`.
