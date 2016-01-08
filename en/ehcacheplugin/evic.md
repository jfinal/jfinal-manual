#EvicInterceptor
1EvictInterceptor1 can clear cache automatically according to CacheName.Following is demo code:


```java
@Before(EvictInterceptor.class) @CacheName("blogList")
public void update() {
   getModel(Blog.class).update();
    redirect("blog.html");
}
```

Above usage will clear the cache data whose cacheName is blogList,CacheInterceptor will update cache data whose cacheName is blogList.
