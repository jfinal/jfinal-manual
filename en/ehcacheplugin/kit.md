#CacheKit
CacheKit is a cache operation utility class,follow is usage code:

```java
public void list() {
List<Blog> blogList = CacheKit.get("blog", "blogList"); if (blogList == null) {
blogList = Blog.dao.find("select * from blog");
CacheKit.put("blog", "blogList", blogList); }
    setAttr("blogList", blogList);
    render("blog.html");
}
```

The most two important methods in CacheKit is get(String cacheName,Object key) and put(String cacheName,Object key,Object value).Get method can get value from cache,put method can put data into cache.Parameter cacheName corresponds to the name of <cache name=”blog”> in ehcache.xml;Parameter key is the key used by value. Parameter value is cached data.

Following code segement is a usage of CacheKit.get(String,String,IDataLoader) overloaded in CacheKit：


```java
public void list() {
    List<Blog> blogList = CacheKit.get("blog", "blogList", new IDataLoader(){
        public Object load() {
            return Blog.dao.find("select * from blog");
        }});
    setAttr("blogList", blogList);
    render("blog.html");
}
```
CacheKit.get method provided a IDataLoader interface,lock() method in this interface will just be invoked when cached data do not exist. The concrete operation processes of this method are as follows: firstly get data from cache with parameters cacheName=blog and key=blogList,return the data in cache if exits,invoke IDataLoader.load() method to get data if not exists.
