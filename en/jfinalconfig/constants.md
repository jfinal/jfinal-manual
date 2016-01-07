#configConstant(Constants me)

This method is used to set constants, such as `devMode`(configuration of develop model constant) and ViewType(configuration of default view type), following code set jfinal project in develop model and the default view type to JSP:

```java
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.JSP);
	}
    ```
In develop model, JFinal outputs the report of each request, such as `Controller`, `Method` and parameters of current request. JFinal support
three commomly-used view types including JSP, FreeMarker and Velocity.

 


