#PropKit
PropKit utility class is used to operate outter configuration files and it can be easily used in anytime and anywhere, the usage is shown as bellow:

```java
public class AppConfig extends JFinalConfig {
    public void configConstant(Constants me) {

    //The configuration loaded by `use` the first time would be the main configuration, which could retrive values via `PropKit.get(...)`
        PropKit.use("a_little_config.txt");
        me.setDevMode(PropKit.getBoolean("devMode"));
    }

    public void configPlugin(Plugins me) {
    // The configuran not loaded by `use` the first time would use `use` to specify config files to retrive values.

        String redisHost = PropKit.use("redis_config.txt").get("host");
        int redisPort = PropKit.use("redis_config.txt").getInt("port");
        RedisPlugin rp = new RedisPlugin("myRedis", redisHost, redisPort);
        me.add(rp);
        // The configuran not loaded by `use` the first time also could get a `Prop` object, through which you can retrive values.
        Prop p = PropKit.use("db_config.txt");
        DruidPlugin dp = new DruidPlugin(p.get("jdbcUrl"), p.get("user")...);
        me.add(dp);
    }
}

```
As code shown above, PropKit support multipul config files, the first file loaded could be operated by `PropKit.get(...)`, the rest files loaded need to use `PropKit.use(...).get(...)` to operate. The useage of `PropKit` is not limited in `YourJFinalConfig`, it could be used anywhere in the project. The underlying implementation of `JFinalConfig`'`getProperty` method depends on `PropKit`.
