#ActiveRecordPlugin

ActiveRecord是作为JFinal的Plugin而存在的，所以使用时需要在JFinalConfig中配置ActiveRecordPlugin。

以下是Plugin配置示例代码

```java
public class DemoConfig extends JFinalConfig {
  public void configPlugin(Plugins me) {
    C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://localhost/db_name", "userName", "password");
    me.add(cp);
    ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
    me.add(arp);
    arp.addMapping("user", User.class);
    arp.addMapping("article", "article_id", Article.class);
  }
}
```

以上代码配置了两个插件：C3p0Plugin与ActiveRecordPlugin，前者是c3p0数据源插件，后者是ActiveRecrod支持插件。ActiveReceord中定义了addMapping(String tableName, Class<? extends Model> modelClass>)方法，该方法建立了数据库表名到Model的映射关系。

另外，以上代码中arp.addMapping(“user”, User.class)，表的主键名为默认为“id”，如果主键名称为 “user_id”则需要手动指定，如：arp.addMapping(“user”, “user_id”, User.class)。
