#Interceptor

Interceptor可以对方法进行拦截，并提供机会在方法的前后添加切面代码，实现AOP的核心目标。Interceptor接口仅仅定了一个方法void intercept(Invocation inv)。以下是简单的示例：

```java
public class DemoInterceptor implements Interceptor {
    public void intercept(Invocation inv) {
        System.out.println("Before method invoking");
        inv.invoke();
        System.out.println("After method invoking");
    }
}
```




以上代码中的DemoInterceptor将拦截目标方法，并且在目标方法调用前后向控制台输出文本。inv.invoke()这一行代码是对目标方法的调用，在这一行代码的前后插入切面代码可以很方便地实现AOP。

Invocation作为Interceptor接口intercept方法中的唯一参数，提供了很多便利的方法在拦截器中使用。以下为Invocation中的方法：
