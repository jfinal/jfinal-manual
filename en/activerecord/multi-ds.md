#Multi-datasource support
ActiveRecordPlugin can support  these features ,like multiple datasources,multiple dialects ,multiple caches and multiple transaction level features at the same time,
In a nutshell,multiple datasources can be used in JFinal at the same time, furthermore these multiple datasources  configure independent dialect,cache,transaction ,etc.

When using multiple datasources,just need to specify a configName for each ActiveRecordPlugin,following code is an example:

```java
public void configPlugin(Plugins me) {
// mysql datasource
C3p0Plugin dsMysql = new C3p0Plugin(…);
me.add(dsMysql);

// Create ActiveRecrodPlugin instances for MySql and specify configName as mysql.
ActiveRecordPlugin arpMysql = new ActiveRecordPlugin("mysql", dsMysql);
me.add(arpMysql);
arpMysql.setCache(new EhCache());
arpMysql.addMapping("user", User.class);

// oracle datasource
C3p0Plugin dsOracle = new C3p0Plugin(…);
me.add(dsOracle);

// Create ActiveRecrodPlugin instances for Oracle and specify configName as oracle.
ActiveRecordPlugin arpOracle = new ActiveRecordPlugin("oracle", dsOracle);
me.add(arpOracle);
arpOracle.setDialect(new OracleDialect());
arpOracle.setTransactionLevel(8);
arpOracle.addMapping("blog", Blog.class);
}
```

Above code has created two ActiveRecordPlugin instances, arpMysql and arpOracle,notice that their configNames have specified as mysql and oracle respectively. ArpMysl and arpOracle have mapped different Model respectively,configured different dialects.

Different `Model`s are able to find the `ActiceRecordPlunin` instance they it belongs to and related configuration to do database operation.
It is also quite handy if you want use the same `Model` in different datasources.
This usage is quite suitable for the scenario where there are some tables having the same table structure in different datasources and developers want to use only one `Model` to operate these tables, the demo code is shown as bellow:

```java
public void multiDsModel() {
//By default, using datasource associated by the invocation of  arp.addMapping(...)
Blog blog = Blog.me.findById(123);

// Only need to invoke use method to shift to another datasource.
blog.use("backupDatabase").save();
}
```

In above case, `blog.use(“backupDatabase”)` method has swifted to backupDatabase datasource and save the data.

<span style='color:red'>NOTE: </span>
The only scenario to use `use` method is where one `Model` need to map to one table multiple  databases. If one `Model` is only mapped to one table in one datasource, the switching between datasources is automatic,so that no need to use `use` method.
so

For the usage of Db + Record, the switching between datasources need to use `Db.use(configName)` to get database operation object, demo usage is shown as bellow:

```java
// Retrive users in mysql datasource.
List<Record> users = Db.use("mysql").find("select * from user");
// Retrive users in oracle datasource.
List<Record> blogs = Db.use("oracle").find("select * from blog");
```
In above two line code, get object used to operate databases via configName mysql and oracle respectively, so that operate database APIs like that in single datasource. In short,  multiple datasources only need one extra invocation `Db,use(configName)` than sigle datasources, all the APIs are the same.

*NOTE:* The `ActiveRecordPlugin` created firstly would be the main datasource and `configName` could be omitted. The configuration of firstly created `ActiveRecordPlugin` would be the main configuration by default. Besides, main configuration can be configured via `configName` constant in `DbKit.MAIN_CONFIG_NAME`.
