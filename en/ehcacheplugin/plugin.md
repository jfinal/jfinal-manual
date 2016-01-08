#EhCachePlugin

EhCachePluginexits as a JFinal plugin,so it is necessary to configure SpringPlugin in JFinalConfig when it is used,following code is an example of plugin configuration:

```java
public class DemoConfig extends JFinalConfig {
    public void configPlugin(Plugins me) {
    me.add(new EhCachePlugin()); }
}
```
