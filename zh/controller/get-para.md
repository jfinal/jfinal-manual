#Action

Controller 以及在其中定义的 public 无参方法称为一个 Action。Action 是请求的最小单位。 Action 方法必须在 Controller 中声明,该方法必须是 public 可见性且没有形参。

```java
public class HelloController extends Controller {
    public void index() {
        renderText("此方法是一个action");
    }
    public void test() {
        renderText("此方法是一个action");
    }
}
```

以上代码中定义了两个 Action:HelloController.index()、HelloController.test()。在 Controller 中提供了 getPara、getModel 系列方法 setAttr 方法以及 render 系列方法供 Action 使用。




