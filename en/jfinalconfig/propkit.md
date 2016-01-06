#PropKit

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


如上代码所示,PropKit 可同时加载多个配置文件,第一个被加载的配置文件可以使用 PorpKit.get(...)方法直接操作,非第一个被加载的配置文件则需要使用 PropKit.use(...).get(...) 来操作。PropKit 的使用并不限于在 YourJFinalConfig 中,可以在项目的任何地方使用, JFinalConfig 的 getProperty 方法其底层依赖于 PropKit 实现。
