#Interceptor的触发

JFinal中的AOP被划分为控制层AOP以及业务层AOP，严格来说业务层AOP并非仅限于在业务层使用，因为JFinal AOP可以应用于其它任何地方。

控制层拦截器的触发，只需发起action请求即可。业务层拦截器的触发需要先使用enhance方法对目标对象进行增强，然后调用目标方法即可。以下是业务层AOP使用的例子：

```java
// 定义需要使用AOP的业务层类
public class OrderService {
    // 配置事务拦截器
    @Before(Tx.class)
    public void payment(int orderId, int userId) {
        // service code here
    }
}

// 定义控制器，控制器提供了enhance系列方法可对目标进行AOP增强
public class OrderController extends Controller {
    public void payment() {
        // 使用 enhance方法对业务层进行增强，使其具有AOP能力
        OrderService service = enhance(OrderService.class);

        // 调用payment方法时将会触发拦截器
        service.payment(getParaToInt("orderId"), getParaToInt("userId"));
    }
}
```
以上代码中OrderService是业务层类，其中的payment方法之上配置了Tx事务拦截器，OrderController是控制器，在其中使用了enhance方法对OrderSevice进行了增强，随后调用其payment方法便可触发Tx拦截器。简言之，业务层AOP的触发相对于控制层仅需多调用一次enhance方法即可，而Interceptor、Before、Clear的使用方法完全一样。
