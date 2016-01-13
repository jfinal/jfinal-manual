#Cache

Efficiency of ActiveRecord can be improved rapidly with cache,following code is an usage example of Cache:


```java
public void list() {
    List<Blog> blogList = Blog.dao.findByCache("cacheName", "key", "select * from blog");
    setAttr("blogList", blogList).render("list.html");
}

```
In above case, `cacheName` in `findByCache` method needs config in `ehcache.xml` like `:<cache name="cacheName" ...>`.

Besides, `Model.paginateByCache(...)`, ` Db.findByCache(...)`, `Db.paginateByCache(...)` provides cache support. Only need pass cacheName, key and config corresponding cacheNqame.
