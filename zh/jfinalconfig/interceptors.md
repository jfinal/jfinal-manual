#configInterceptor (Interceptors me)

此方法用来配置JFinal的Interceptor，如下代码配置了名为AuthInterceptor的拦截器，在此处配置的拦截器将会对所有的请求进行拦截，除非使用@ClearInterceptor在Controller中清除。

	public void configInterceptor(Interceptors me) {
		me.add(new AuthInterceptor());
	}
	
JFinal的Interceptor非常类似于Struts2，但使用起来更方便，Interceptor配置粒度分为Global、Controller、Action三个层次，其中以上代码配置粒度为全局。Controller与Action级的Interceptor配置将在后续章节中详细介绍。


