#多数据源支持

ActiveRecordPlugin可同时支持多数据源、多方言、多缓存、多事务级别等特性，对每个 ActiveRecordPlugin 可进行彼此独立的配置。简言之 JFinal 可以同时使用多数据源，并且可以针对这多个数据源配置独立的方言、缓存、事务级别等。

当使用多数据源时，只需要对每个 ActiveRecordPlugin指定一个 configName即可，如下是代码示例：

```java
public void configPlugin(Plugins me) {
// mysql 数据源
C3p0Plugin dsMysql = new C3p0Plugin(…);
me.add(dsMysql);

// mysql ActiveRecrodPlugin 实例，并指定configName为 mysql
ActiveRecordPlugin arpMysql = new ActiveRecordPlugin("mysql", dsMysql);
me.add(arpMysql);
arpMysql.setCache(new EhCache());
arpMysql.addMapping("user", User.class);

// oracle 数据源
C3p0Plugin dsOracle = new C3p0Plugin(…);
me.add(dsOracle);

// oracle ActiveRecrodPlugin 实例，并指定configName为 oracle
ActiveRecordPlugin arpOracle = new ActiveRecordPlugin("oracle", dsOracle);
me.add(arpOracle);
arpOracle.setDialect(new OracleDialect());
arpOracle.setTransactionLevel(8);
arpOracle.addMapping("blog", Blog.class);
}
```

以上代码创建了创了两个ActiveRecordPlugin实例arpMysql与arpOrace，特别注意创建实例的同时指定其configName分别为mysql与oracle。arpMysql与arpOracle分别映射了不同的Model，配置了不同的方言。

对于Model的使用，不同的Model会自动找到其所属的ActiveRecrodPlugin实例以及相关配置进行数据库操作。假如希望同一个Model能够切换到不同的数据源上使用，也极度方便，这种用法非常适合不同数据源中的table拥有相同表结构的情况，开发者希望用同一个Model来操作这些相同表结构的table，以下是示例代码：

```java
public void multiDsModel() {
// 默认使用arp.addMapping(...)时关联起来的数据源
Blog blog = Blog.me.findById(123);

// 只需调用一次use方法即可切换到另一数据源上去
blog.use("backupDatabase").save();
}
```

上例中的代码，blog.use(“backupDatabase”)方法切换数据源到backupDatabase并直接将数据保存起来。

<span style='color:red'>特别注意：</span>只有在同一个Model希望对应到多个数据源的table时才需要使用use方法，如果同一个Model唯一对应一个数据源的一个table，那么数据源的切换是自动的，无需使用use方法。

对于Db + Record的使用，数据源的切换需要使用Db.use(cnfigName)方法得到数据库操作对象，然后就可以进行数据库操作了，以下是代码示例：

```java
// 查询 dsMysql数据源中的 user
List<Record> users = Db.use("mysql").find("select * from user");
// 查询 dsOracle数据源中的 blog
List<Record> blogs = Db.use("oracle").find("select * from blog");
```
以上两行代码，分别通过configName为mysql、oracle得到各自的数据库操作对象，然后就可以如同单数据完全一样的方式来使用数据库操作 API了。简言之，对于 Db + Record来说，多数据源相比单数据源仅需多调用一下Db.use(configName)，随后的API使用方式完全一样。

注意最先创建的 ActiveRecrodPlugin实例将会成为主数据源，可以省略configName。最先创建的 ActiveRecrodPlugin实例中的配置将默认成为主配置，此外还可以通过设置configName为 DbKit.MAIN_CONFIG_NAME常量来设置主配置。
