#FreeMarker Basics


JFinal use Freemaker as View by default,in order to let eclipse can correctly recognise html,use ".html" as extension name of Freemarker file( original name is ".ftl").
If you need to use JSP as defalut view,you need to configure in configConstant(Constants me) method,see the following configuration:


```java
public void configConstant(Constants me) {
    me.setDevMode(true);
    me.setViewType(ViewType.JSP);
}

```
