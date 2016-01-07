#configPlugin (Plugins me)

This method is used to configurate JFinal Plugin,following code has configurated plugin of C3p0 database connection pool and ActiveRecord
Database access plugin.With following configuration,it is very convience to operate database.

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

JFinal plugin architecture is one of the main extension methods, you could effortlessly create plugins and apply in projects.



