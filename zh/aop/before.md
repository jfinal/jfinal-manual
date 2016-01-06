#Before

Before注解用来对拦截器进行配置，该注解可配置Class、Method级别的拦截器，以下是代码示例：

```java
// 配置一个Class级别的拦截器，她将拦截本类中的所有方法
@Before(AaaInter.class)
public class BlogController extends Controller {

    // 配置多个Method级别的拦截器，仅拦截本方法
    @Before({BbbInter.class, CccInter.class})
    public void index() {
    }

    // 未配置Method级别拦截器，但会被Class级别拦截器AaaInter所拦截
    public void show() {
    }
}
```

如上代码所示，Before可以将拦截器配置为Class级别与Method级别，前者将拦截本类中所有方法，后者仅拦截本方法。此外Before可以同时配置多个拦截器，只需用在大括号内用逗号将多个拦截器进行分隔即可。

除了Class与Method级别的拦截器以外，JFinal还支持全局拦截器以及Inject拦截器（Inject拦截将在后面介绍），全局拦截器分为控制层全局拦截器与业务层全局拦截器，前者拦截控制 层所有Action方法，后者拦截业务层所有方法。

全局拦截器需要在YourJFinalConfig进行配置，以下是配置示例：

```java
public class AppConfig extends JFinalConfig {
    public void configInterceptor(Interceptors me) {
        // 添加控制层全局拦截器
        me.addGlobalActionInterceptor(new GlobalActionInterceptor());

        // 添加业务层全局拦截器
        me.addGlobalServiceInterceptor(new GlobalServiceInterceptor());

        // 为兼容老版本保留的方法，功能与addGlobalActionInterceptor完全一样
        me.add(new GlobalActionInterceptor());
    }
}
```

当某个Method被多个级别的拦截器所拦截，拦截器各级别执行的次序依次为：Global、Inject、Class、Method，如果同级中有多个拦截器，那么同级中的执行次序是：配置在前面的先执行。
