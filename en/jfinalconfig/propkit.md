#PropKit
PropKit utility class is used to operate outter configuration files
PropKit 工具类用来操作外部配置文件。PropKit 可以极度方便地在系统任意时空使用,如 下是示例代码:

```java
public class AppConfig extends JFinalConfig {
    public void configConstant(Constants me) {
        // 第一次使用use加载的配置将成为主配置,可以通过PropKit.get(...)直接取值
        PropKit.use("a_little_config.txt");
        me.setDevMode(PropKit.getBoolean("devMode"));
    }

    public void configPlugin(Plugins me) {
        // 非第一次使用use加载的配置,需要通过每次使用use来指定配置文件名再来取值
        String redisHost = PropKit.use("redis_config.txt").get("host");
        int redisPort = PropKit.use("redis_config.txt").getInt("port");
        RedisPlugin rp = new RedisPlugin("myRedis", redisHost, redisPort);
        me.add(rp);
        // 非第一次使用 use加载的配置,也可以先得到一个Prop对象,再通过该对象来获取值
        Prop p = PropKit.use("db_config.txt");
        DruidPlugin dp = new DruidPlugin(p.get("jdbcUrl"), p.get("user")...);
        me.add(dp);
    }
}

```
As code shown above, PropKit support multipul config files, the first file loaded could be operated by `PropKit.get(...)`, the rest files loaded need to use `PropKit.use(...).get(...)` to operate. The useage of `PropKit` is not limited in `YourJFinalConfig`, it could be used anywhere in the project. The underlying implementation of `JFinalConfig`'`getProperty` method depends on `PropKit`.
