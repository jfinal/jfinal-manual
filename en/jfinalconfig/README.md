#Introduction

A JFinal-based web project needs to create a subclass of JFinalConfig class, which is used to configure the whole project.

The subclass of JFinal needs to implement 5 abstract methods, shown as below:

```java
	public class DemoConfig extends JFinalConfig {
		public void configConstant(Constants me) {}
		public void configRoute(Routes me) {}
		public void configPlugin(Plugins me) {}
		public void configInterceptor(Interceptors me) {}
		public void configHandler(Handlers me) {}
	}
```
