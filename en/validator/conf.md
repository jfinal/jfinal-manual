#Validator Configuration

How to configure `Validator` is the completely the same with `Interceptor`, shown as follow:

```java
public class UserController extends Controller {
    @Before(LoginValidator.class) // The same with Interceptor
    public void login() {
    }
}
```
