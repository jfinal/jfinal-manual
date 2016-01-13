#Support for Oracle
Oracle database is specific, Considering these particularity,JFinal has some extra support to Oracle users. Following demo is a complete oracle configuration:

```java
public class DemoConfig extends JFinalConfig {
  public void configPlugin(Plugins me) {
    C3p0Plugin cp = new C3p0Plugin(……);
    //Configure Oracle driver
    cp.setDriverClass("oracle.jdbc.driver.OracleDriver");
    me.add(cp);
    ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
    me.add(arp);
    //Configure Oracle dialect
    arp.setDialect(new OracleDialect());
    // Configure CaseInsensitiveContainerFactory for attributes and fields
    arp.setContainerFactory(new CaseInsensitiveContainerFactory());
    arp.addMapping("user", "user_id", User.class);
  }
}
```

Since oracle database can convert columns to uppercase characters automatically,You need to specify the primary key name to uppercase manually.
 For example: arp.addMapping(“user”,”ID”,User.class).
If you want to make ActiveRecord non-sensitive to attribute, setting CaseInsensitiveContainerFactory is set to reach. With this setting, arp.addMapping(“user”,”ID”,User.class) is not need no longer.

Besides, oracle have not support auto increment primary key directly ,JFinal has provided a convenient solution. In order to let oracle support auto increment primary key  consists of two major steps:  first create sequence,second use this sequence in model,The specific measures are as follows:


1: Create sequence through the following methods, in this case ,the sequence name is : MY_SEQ

```mysql
CREATE SEQUENCE MY_SEQ
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 1
 CACHE 20;
```



2: Use sequence created above in YourModel.set(...)

```java
// Create User and use sequence
User user = new User().set("id", "MY_SEQ.nextval").set("age", 18);
user.save();
// Get id value.
Integer id = user.get("id");
```
, just need to code yourModel.set(primary key,sequence name).



It is easy to use sequence, just need yourModel.set(primary key, sequence name <span style='color:red'>+ “.nextval”)</span>.

 <span style='color:red'> Pay special attention to '.nextval',the suffix should be lower-case, because `OracleDialect` is case-sensitive to that value.</span>
