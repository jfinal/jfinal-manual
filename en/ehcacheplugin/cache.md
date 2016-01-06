#Cacheinterceptor

CacheInterceptor 可以将 action 所需数据全部缓存起来,下次请求到来时如果 cache 存在则 直接使用数据并 render,而不会去调用 action。此用法可使 action 完全不受 cache 相关代码所 污染,即插即用,以下是示例代码:

```java
@Before(CacheInterceptor.class) public void list() {
    List<Blog> blogList = Blog.dao.find("select * from blog"); User user = User.dao.findById(getParaToInt());
    setAttr("blogList", blogList);
    setAttr("user", user);
    render("blog.html");
}
```

上例中的用法将使用 actionKey 作为 cacheName,在使用之前需要在 ehcache.xml 中配置以 actionKey 命名的 cache 如:<cache name="/blog/list" ...>,注意 actionKey 作为 cacheName 配置 时斜杠”/”不能省略。此外 CacheInterceptor 还可以与 CacheName 注解配合使用,以此来取代
http://www.jfinal.com
默认的 actionKey 作为 actionName,以下是示例代码:

```java
@Before(CacheInterceptor.class) @CacheName("blogList")
public void list() {
    List<Blog> blogList = Blog.dao.find("select * from blog");
    setAttr("blogList", blogList);
    render("blog.html");
}
```

以上用法需要在 ehcache.xml 中配置名为 blogList 的 cache 如:<cache name="blogList" ...>。
