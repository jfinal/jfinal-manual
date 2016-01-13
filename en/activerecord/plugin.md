#ActiveRecordPlugin

ActiveRecordPluin exits as a JFinal plugin,so it is necessary to configure ActiveRecordPluin in JFinalConfig when it is used,following code is an example of plugin configuration:

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

Above code has cofigured two plugins: C3p0Plugin and ActiveRecordPlugin,the former is c3p0 datasource plugin, the latter is ActiveRecord plugin support. In ActiveRecord, addMapping(String tableName,Class<? Extends Model> modelCalss>) method has been defined,this method has built a mapping from database table name to Model.
In addition, primary key of table is “id” by default in arp.addMapping(“user”,User.class) of above code. Pramary key should be specified manually if its name is “user_id”.
