#添加 java 文件

在项目`src`目录下创建`demo`包，并在`demo`包下创建`DemoConfig`文件， 内容如下：
```java
    package demo;
	import com.jfinal.config.Constants;
	import com.jfinal.config.Handlers;
	import com.jfinal.config.Interceptors;
	import com.jfinal.config.JFinalConfig;
	import com.jfinal.config.Plugins;
	import com.jfinal.config.Routes;
	public class DemoConfig extends JFinalConfig {
		public void configConstant(Constants me) {
			me.setDevMode(true);
		}
		public void configRoute(Routes me) {
			me.add("/hello", HelloController.class);
		}
		public void configPlugin(Plugins me) {}
		public void configInterceptor(Interceptors me) {}
		public void configHandler(Handlers me) {}
	}
```	
注意：`DemoConfig.java`文件所在的包以及自身文件名必须与`web.xml`中的`param-value`标签内的配置相一致(在本例中该配置为`demo.DemoConfig`)。

在`demo`包下创建`HelloController`类文件， 内容如下：

```java
	package demo;
	import com.jfinal.core.Controller;
	public class HelloController extends Controller {
		public void index() {
			renderText("Hello JFinal world.");
		}
	}
```


