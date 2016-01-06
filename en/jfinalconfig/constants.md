#configConstant(Constants me)

This method is used to set constants,such as devMode,configuration of develop model constant and ViewType,configuration of default view type, following code set jfinal project in develop model and the  default view type to JSP:


此方法用来配置JFinal常量值，如开发模式常量devMode的配置，默认视图类型ViewType的配置，
如下代码配置了JFinal运行在开发模式下且默认视图类型为JSP：
```java
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.JSP);
	}
    ```
In develop model,JFinal outputs the report of each request,such as  Controller,Method and parameters of current request. JFinal support
three commomly used view types including JSP,FreeMarker and Velocity.
在开发模式下，JFinal会对每次请求输出报告，如输出本次请求的Controller、Method以及请求所携带的参数。
JFinal支持JSP、FreeMarker、Velocity三种常用视图。
 


