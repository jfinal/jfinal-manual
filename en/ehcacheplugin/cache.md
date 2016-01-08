#Cacheinterceptor

CacheInterceptor can cache all the required data, then use data and render ,not invoke action,if cache exists when next request arrives.This method can make the action completely not contaminated by cache-related code,plug and play ,following is example code:

```java
@Before(CacheInterceptor.class) public void list() {
    List<Blog> blogList = Blog.dao.find("select * from blog"); User user = User.dao.findById(getParaToInt());
    setAttr("blogList", blogList);
    setAttr("user", user);
    render("blog.html");
}
```
Above example has used `actionKey` as cacheName, before you use it,you need to configure a cache named by `actionKey` in ehcache.xml(e.g. <cache name="/blog/list" ...>),notice that forward slash “/” can be omitted when actionKey is configured as cacheName.
Besides `CacheInterceptor` can be used in concert with `CacheName` annotation, in order to replace default `actionKey` as `actionName`, following code is an example:

```java
@Before(CacheInterceptor.class) @CacheName("blogList")
public void list() {
    List<Blog> blogList = Blog.dao.find("select * from blog");
    setAttr("blogList", blogList);
    render("blog.html");
}
```

For about usage,you need to cofigure a cache named blogList in ehcache.xml,e.g.,`<cache name="blogList" ...>`.
