#FreeMarker 基础

JFinal 默认使用 FreeMarker 作为 View,为了使 eclipse jee 能正确识别 html,所以默认使 用”.html”作为 FreeMarker 视图文件的扩展名(原为”.ftl”)。
如果需要使用 JSP 作为默认视图需要在 configConstant(Constants me)方法中进行配置,见 如下配置:

```java
public void configConstant(Constants me) {
    me.setDevMode(true);
    me.setViewType(ViewType.JSP);
}

```
