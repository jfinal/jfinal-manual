#CacheKit

CacheKit 是缓存操作工具类,以下是示例代码:

CacheKit 中最重要的两个方法是 get(String cacheName, Object key)与 put(String cacheName,
Object key, Object value)。get 方法是从 cache 中取数据,put 方法是将数据放入 cache。参数 cacheName 与 ehcache.xml 中的<cache name="blog" ...>name 属性值对应;参数 key 是指取值用 到的 key;参数 value 是被缓存的数据。

以下代码是 CacheKit 中重载的 CacheKit.get(String, String, IDataLoader)方法使用示例:

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

CacheKit.get 方法提供了一个 IDataLoader 接口,该接口中的 load()方法在缓存值不存在时 才会被调用。该方法的具体操作流程是:首先以 cacheName=blog 以及 key=blogList 为参数去 缓存取数据,如果缓存中数据存在就直接返回该数据,不存在则调用 IDataLoader.load()方法来 获取数据。
