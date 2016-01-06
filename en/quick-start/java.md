#Add Java Files

Create `demo` package in `src` folder and create `DemoConfig` in `demo` package, the content is as follow:

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
**NOTE:** The package where the `DemoConfig.java` file is and its filename must keep the the same as config in param-value in the web.xml(in this case, the value of the config is `demo.DemoConfig`).

Create `HelloController` class file in `demo` package, content is as follow:

```java
	package demo;
	import com.jfinal.core.Controller;
	public class HelloController extends Controller {
		public void index() {
			renderText("Hello JFinal world.");
		}
	}
```


