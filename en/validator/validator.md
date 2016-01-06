#Validator
Validator 自身实现了 Interceptor 接口,所以它也是一个拦截器,配置方式与拦截器完全一 样。以下是 Validator 示例:

```java
public class LoginValidator extends Validator {
    protected void validate(Controller c) {
        validateRequiredString("name", "nameMsg", "请输入用户名");
        validateRequiredString("pass", "passMsg", "请输入密码");
}
    protected void handleError(Controller c) {
        c.keepPara("name");
        c.render("login.html");
    }
}
```
protected void validator(Controller c)方法中可以调用 validateXxx(...)系列方法进行后端校 验,protected void handleError(Controller c)方法中可以调用 c.keepPara(...)方法将提交的值再传 回页面以便保持原先输入的值,还可以调用 c.render(...)方法来返回相应的页面。注意 handleError(Controller c)只有在校验失败时才会调用。

以上代码 handleError 方法中的 keepXxx 方法用于将页面表单中的数据保持住并传递回页, 以便于用户无需再重复输入已经通过验证的表单域,如果传递过来的是 model 对象,可以使用 keepModel 方法来保持住用户输入过的数据。
