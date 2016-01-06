#Clear

拦截器从上到下依次分为Global、Inject、Class、Method四个层次，Clear用于清除自身所处层次以上层的拦截器。

Clear声明在Method层时将针对Global、Inject、Class进行清除。Clear声明在Class层时将针对Global、Inject进行清除。Clear注解携带参数时清除目标层中指定的拦截器。

<span style='color:red'>Clear用法记忆技巧：</span>

- 共有Global、Inject、Class、Method四层拦截器
- 清除只针对Clear本身所处层的向上所有层，本层与下层不清除
- 不带参数时清除所有拦截器，带参时清除参数指定的拦截器

在某些应用场景之下，需要移除Global或Class拦截器。例如某个后台管理系统，配置了一个全局的权限拦截器，但是其登录action就必须清除掉她，否则无法完成登录操作，以下是代码示例：


```java
// login方法需要移除该权限拦截器才能正常登录
@Before(AuthInterceptor.class)
public class UserController extends Controller {
    // AuthInterceptor 已被Clear清除掉，不会被其拦截
    @Clear
    public void login() {
    }

    // 此方法将被AuthInterceptor拦截
    public void show() {
    }
}
```

Clear注解带有参数时，能清除指定的拦截器，以下是一个更加全面的示例：

```java
@Before(AAA.class)
public class UserController extends Controller {
    @Clear
    @Before(BBB.class)
    public void login() {
    // Global、Class级别的拦截器将被清除，但本方法上声明的BBB不受影响
}

    @Clear({AAA.class, CCC.class})// 清除指定的拦截器AAA与CCC
    @Before(CCC.class)
    public void show() {
    // 虽然Clear注解中指定清除CCC，但她无法被清除，因为清除操作只针对于本层以上的各层
    }
}
```
