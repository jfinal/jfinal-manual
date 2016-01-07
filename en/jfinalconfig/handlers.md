#configHandler (Handlers me)

This method is used to configure JFinal `Handler`, following code has configure a handler named ResourceHandler. Handler could handle all the http requests and has the complete right of control of application, which could easily implement high-level extension.

```java
	public void configHandler(Handlers me) {
		me.add(new ResourceHandler());
	}
```


