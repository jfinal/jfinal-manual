#EhCachePlugin

EhCachePlugin 是作为 JFinal 的 Plugin 而存在的,所以使用时需要在 JFinalConfig 中配置 EhCachePlugin,以下是 Plugin 配置示例代码:

```java
public class DemoConfig extends JFinalConfig {
    public void configPlugin(Plugins me) {
    me.add(new EhCachePlugin()); }
}
```
