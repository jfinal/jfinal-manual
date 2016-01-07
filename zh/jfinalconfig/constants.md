#configConstant(Constants me)

此方法用来配置JFinal常量值，如开发模式常量devMode的配置，默认视图类型ViewType的配置，
如下代码配置了JFinal运行在开发模式下且默认视图类型为JSP：
```java
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.JSP);
	}
```
在开发模式下，JFinal会对每次请求输出报告，如输出本次请求的Controller、Method以及请求所携带的参数。
JFinal支持JSP、FreeMarker、Velocity三种常用视图。
 


