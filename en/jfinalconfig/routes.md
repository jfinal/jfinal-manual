#configRoute(Routes me)

This method is used to configure route of JFinal,following code sets the HelloController to which maps "/hello"

Through the following configuration, http://localhost/hello would access to `HelloController.index()` method

```java
	public void configRoute(Routes me) {
		me.add("/hello", HelloController.class);
	}
```	

The two main methods of `Routes` are as follows:


```java
public Routes add(String controllerKey, Class<? extends Controller>
                   controllerClass, String viewPath)
public Routes add(String controllerKey, Class<? extends Controller>
                   controllerClass)
```

The first parameter `controllerKey` is the first character string of calling a Controller, the character string is mapped to a Controller, `controllerKey` just can navigate to Controller.

The second parameter `controllerClass` is the Controller to which controllerKey maps.

The third parameter `viewPath` is the relative path of view returned by this `Controller`.(The details of this parameter will be given in the Chapter about Controller.)The default value is the same as controllerKey's when viewPath is unspecified.

The rules of JFinal routes are as follows:


| url                     |  targer
|----------------------------|----------
| controllerKey              | YourController.index()  
| controllerKey/method       | YourController.method() 
| controllerKey/method/v0_v1 | YourController.method()，所带url参数值为：v0_v1 
| controllerKey/v0_v1        |YourController.index()，所带url参数值为：v0_v1 

  It can be seen from the table that it is necessary to use controllerKey and method to navigate accurately when a  exact action (The defination is in Chapter 3.2)is accessed by JFinal and the default value is index when method is omitted.In order to carrying over parameters in url,urlPara can carry more than one parameter in one request and JFinal use '-' by default to seperate values(can set separative sign by using constants.setUrlParaSeparator(String)).In Controller, these values can be retrieved by using getPara（int index).
These three parts including controllerKey,method,urlPara must be seperated by using forward slash '/'.

**Notice,** controller itself also can contain forward slash '/' ,such as '/admin/article', in fact this has relized the namespace function of struts2.

 Except above route rules, JFinal also provide a annotation ActionKey,which can break original rules,following code is an example:

```java
public class UserController extends Controller {
   @ActionKey("/login")
   public void login() {
       render("login.html");
    }
}
```

Assume `controllerKey` of `UserController` is `/user`, the value of `actionKey` would change from '/user/login' to '/login' after using @ActionKey("/login") annotation.


JFinal routes also could be config seperately, which is quite useful for large-scale team development,demo code is shown as bellow:

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
        me.add(new FrontRoutes()); // Front-end Routes
        me.add(new AdminRoutes()); // Back-end Routes
    }
    public void configConstant(Constants me) {}
    public void configPlugin(Plugins me) {}
    public void configInterceptor(Interceptors me) {}
    public void configHandler(Handlers me) {}
}
```

In the above three segment codes, front-end routes are configue in FrontRoutes,back-end routes are configurated in AdminRoutes, and these two routes are merged by MyJFinalConfig.configRoute(...) method.

With a seperate config, it is not only simplify MyJFinalConfig file, but also benificial to  large-scale team development, preventing the conflicting document versions that can result when several people are working on `MyJFinalConfig` simultaneously.
