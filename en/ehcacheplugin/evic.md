#EvicInterceptor
EvictInterceptor 可以根据 CacheName 注解自动清除缓存。以下是示例代码:

```java
@Before(EvictInterceptor.class) @CacheName("blogList")
public void update() {
   getModel(Blog.class).update();
    redirect("blog.html");
}
```
上例中的用法将清除 cacheName 为 blogList 的缓存数据,与其配合的 CacheInterceptor 会 自动更新 cacheName 为 blogList 的缓存数据。
