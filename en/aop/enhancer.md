#Duang, Enhancer

Duang、Enhancer用来对目标进行增强，让其拥有AOP的能力。以下是代码示例：

```java
public class TestMain{
    public void main(String[] args) {
        // 使用Duang.duang方法在任何地方对目标进行增强
        OrderService service = Duang.duang(OrderService.class);
        // 调用payment方法时将会触发拦截器
        service.payment(…);

// 使用Enhancer.enhance方法在任何地方对目标进行增强
        OrderService service = Enhancer.enhance(OrderService.class);
    }
}
```

Duang.duang()、Enhancer.enhance()与Controller.enhance()系方法在功能上完全一样，她们除了支持类增强以外，还支持对象增强，例如duang(new OrderService())以对象为参数的用法，功能本质上是一样的，在此不再赘述。
使用Duang、Enhancer类可以对任意目标在任何地方增强，所以JFinal的AOP可以应用于非web项目，只需要引入jfinal.jar包，然后使用Enhancer.enhance()或Duang.duang()即可极速使用JFinal的AOP功能。
