#Oracle支持

Oracle数据库具有一定的特殊性，JFinal针对这些特殊性进行了一些额外的支持以方便广大的Oracle使用者。以下是一个完整的Oracle配置示例：

```java
public class DemoConfig extends JFinalConfig {
  public void configPlugin(Plugins me) {
    C3p0Plugin cp = new C3p0Plugin(……);
  //配置Oracle驱动
  cp. setDriverClass("oracle.jdbc.driver.OracleDriver");
    me.add(cp);
    ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
    me.add(arp);
    // 配置Oracle方言
  arp.setDialect(new OracleDialect());
  // 配置属性名(字段名)大小写不敏感容器工厂
  arp.setContainerFactory(new CaseInsensitiveContainerFactory());
  arp.addMapping("user", "user_id", User.class);
  }
}
```
由于Oracle数据库会自动将属性名(字段名)转换成大写，所以需要手动指定主键名为大写，如：arp.addMaping(“user”, “ID”, User.class)。如果想让ActiveRecord对属性名（字段名）的大小写不敏感可以通过设置CaseInsensitiveContainerFactory来达到，有了这个设置，则arp.addMaping(“user”, “ID”, User.class)不再需要了。

另外，Oracle并未直接支持自增主键，JFinal为此提供了便捷的解决方案。要让Oracle支持自动主键主要分为两步：一是创建序列，二是在model中使用这个序列，具体办法如下：
1：通过如下办法创建序列，本例中序列名为：MY_SEQ

```mysql
CREATE SEQUENCE MY_SEQ
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999
 START WITH 1
 CACHE 20;
```




2：在YourModel.set(…)中使用上面创建的序列

```java
// 创建User并使用序列
User user = new User().set("id", "MY_SEQ.nextval").set("age", 18);
user.save();
// 获取id值
Integer id = user.get("id");
```



序列的使用很简单，只需要 yourModel.set(主键名, 序列名 <span style='color:red'>+ “.nextval”)</span>就可以了。<span style='color:red'>特别注意这里的 “.nextval” 后缀一定要是小写，OracleDialect对该值的大小写敏感。</span>
