#configRoute(Routes me)

此方法用来配置JFinal访问路由，如下代码配置了将”/hello”映射到HelloController这个控制器，
通过以下的配置，http://localhost/hello 将访问 HelloController.index()方法，
而http://localhost/hello/methodName 将访问到 HelloController.methodName()方法。

```java
	public void configRoute(Routes me) {
		me.add("/hello", HelloController.class);
	}
```

Routes 类主要有如下两个方法：

```java
public Routes add(String controllerKey, Class<? extends Controller>
                   controllerClass, String viewPath)
public Routes add(String controllerKey, Class<? extends Controller>
                   controllerClass)
```

第一个参数controllerKey是指访问某个Controller所需要的一个字符串，该字符串唯一对应一个Controller，controllerKey仅能定位到Controller。
第二个参数controllerClass是该controllerKey所对应到的Controller。
第三个参数viewPath是指该Controller返回的视图的相对路径(该参数具体细节将在Controller相关章节中给出)。
当viewPath未指定时默认值为controllerKey。

JFinal路由规则如下表：

| url组成                     |  访问目标 
|----------------------------|----------
| controllerKey              | YourController.index()  
| controllerKey/method       | YourController.method() 
| controllerKey/method/v0_v1 | YourController.method()，所带url参数值为：v0_v1 
| controllerKey/v0_v1        |YourController.index()，所带url参数值为：v0_v1 

从表中可以看出，JFinal访问一个确切的Action(Action定义见3.2节)需要使用controllerKey与method来精确定位，当method省略时默认值为index。
urlPara是为了能在url中携带参数值，urlPara可以在一次请求中同时携带多个值，JFinal默认使用减号“-”来分隔多个值（可通过constants. setUrlParaSeparator(String)设置分隔符），
在Controller中可以通过getPara(int index)分别取出这些值。controllerKey、method、urlPara这三部分必须使用正斜杠“/”分隔。

**注意，**controllerKey自身也可以包含正斜杠“/”，如“/admin/article”，这样实质上实现了struts2的namespace功能。

JFinal 在以上路由规则之外还提供了 ActionKey 注解,可以打破原有规则,以下是代码示例:


```java
public class UserController extends Controller {
   @ActionKey("/login")
   public void login() {
       render("login.html");
    }
}
```
假定 UserController 的 controllerKey 值为“/user”,在使用了@ActionKey(“/login”)注解以 后,actionKey 由原来的“/user/login”变为了“/login”。该注解还可以让 actionKey 中使用减号或 数字等字符,如“/user/123-456”。

如果 JFinal 默认路由规则不能满足需求,开发者还可以根据需要使用 Handler 定制更加个 性化的路由,大体思路就是在 Handler 中改变第一个参数 String target 的值。

JFinal 路由还可以进行拆分配置,这对大规模团队开发特别有用,以下是代码示例:

```java
public class FrontRoutes extends Routes {
    public void config() {
    add("/", IndexController.class);
    add("/blog", BlogController.class);
    }
}

public class AdminRoutes extends Routes {
    public void config() {
        add("/admin", AdminController.class);
        add("/admin/user", UserController.class);
    }
}

public class MyJFinalConfig extends JFinalConfig {
    public void configRoute(Routes me) {
        me.add(new FrontRoutes()); // 前端路由
        me.add(new AdminRoutes()); // 后端路由
    }
    public void configConstant(Constants me) {}
    public void configPlugin(Plugins me) {}
    public void configInterceptor(Interceptors me) {}
    public void configHandler(Handlers me) {}
}
```

如上三段代码,FrontRoutes 类中配置了系统前端路由,AdminRoutes 配置了系统后端路由, MyJFinalConfig.configRoute(...)方法将拆分后的这两个路由合并起来。使用这种拆分配置不仅 可以让 MyJFinalConfig 文件更简洁,而且有利于大规模团队开发,避免多人同时修改 MyJFinalConfig 时的版本冲突。
