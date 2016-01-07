#configHandler (Handlers me)

此方法用来配置JFinal的Handler，如下代码配置了名为ResourceHandler的处理器，Handler可以接管所有web请求，并对应用拥有完的控制权，可以很方便地实现更高层的功能性扩展。

```java
	public void configHandler(Handlers me) {
		me.add(new ResourceHandler());
	}
```


