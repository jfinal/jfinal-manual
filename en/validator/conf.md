#Validator配置

Validator 配置方式与拦截器完全一样,见如下代码:

```java
public class UserController extends Controller {
    @Before(LoginValidator.class) // 配置方式与拦截器完全一样
    public void login() {
    }
}
```
