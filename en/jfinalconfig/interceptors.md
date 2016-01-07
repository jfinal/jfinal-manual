#configInterceptor (Interceptors me)

This method is used to configure JFinal `Interceptor`, following code has configure
an `Interceptor` named AuthInterceptor, the `Interceptor` here would intercept all requests unless using @ClearInterceptor to clear `Inteceptor`s in `Controller`,


```java
	public void configInterceptor(Interceptors me) {
		me.add(new AuthInterceptor());
	}
```

JFinal `Inteceptor` is quite similary to Struts2' Inteceptor, but easier to use.
`Interceptor` has three level of granularity including Glable, Controller and Action to support any desied configuration,the granularity of above code is Global.
The `Inteceptor` of Controllr and Action level would be introduced in detail in follow chapters.


