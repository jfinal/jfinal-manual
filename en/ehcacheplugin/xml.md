#ehcache.xml简介
EhCache 的使用需要有 ehcache.xml 配置文件支持,该配置文件中配置了很多 cache 节点, 每个 cache 节点会配置一个 name 属性,例如:<cache name="blog" ...>,该属性是 CacheKit 取值所必须的。其它配置项如 eternal、overflowToDisk、timeToIdleSeconds、timeToLiveSeconds 详见 EhCache 官方文档。
