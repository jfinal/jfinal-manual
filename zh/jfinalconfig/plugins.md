#configPlugin (Plugins me)
This method is used to configurate JFinal Plugin,following code has configurated plugin of C3p0 database connection pool and ActiveRecord
Database access plugin.With following configuration,it is very convience to operate database.
此方法用来配置JFinal的Plugin，如下代码配置了C3p0数据库连接池插件与ActiveRecord数据库访问插件。通过以下的配置，可以在应用中使用ActiveRecord非常方便地操作数据库。

```java
	public void configPlugin(Plugins me) {
		loadPropertyFile("your_app_config.txt");
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"), 
								getProperty("user"), getProperty("password"));
		me.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("user", User.class);
	}
```


JFinal plugin architecture is one of the main extended modesl.
JFinal插件架构是其主要扩展方式之一，可以方便地创建插件并应用到项目中去。


