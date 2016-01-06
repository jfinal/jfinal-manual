#Inject拦截器

Inject拦截器是指在使用enhance或duang方法增强时使用参数传入的拦截器。Inject可以对目标完全无侵入地应用AOP。

假如需要增强的目标在jar包之中，无法使用Before注解对其配置拦截器，此时使用Inject拦截器可以对jar包中的目标进行增强。如下是Inject拦截器示例：

```java
public void injectDemo() {
    // 为enhance方法传入的拦截器称为Inject拦截器，下面代码中的Tx称为Inject拦截器
    OrderService service = Enhancer.enhance(OrderService.class, Tx.class);
    service.payment(…);
}
```

如上代码中Enhance.enhance()方法的<span style="color:red">第二个参数Tx.class</span>被称之为Inject拦截器，使用此方法便可完全无侵入地对目标进行AOP增强。

Inject拦截器与前面谈到的Global、Class、Method级别拦截器是同一层次上的概念。与Class级拦截器一样，Inject拦截器将拦截被增强目标中的所有方法。Inject拦截器可以被认为就是Class级拦截器，只不过执行次序在Class级拦截器之前而已。
