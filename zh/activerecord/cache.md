#Cach

ActiveRecord 可以使用缓存以大大提高性能,以下代码是 Cache 使用示例:

```java
public void list() {
    List<Blog> blogList = Blog.dao.findByCache("cacheName", "key", "select * from blog");
    setAttr("blogList", blogList).render("list.html");
}

```
上例 findByCache 方法中的 cacheName 需要在 ehcache.xml 中配置如:<cache name="cacheName" ...> 。 此 外 Model.paginateByCache(...) 、 Db.findByCache(...) 、 Db.paginateByCache(...)方法都提供了 cache 支持。在使用时,只需传入 cacheName、key 以及 在 ehccache.xml 中配置相对应的 cacheName 就可以了。e
