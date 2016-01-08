#Action

Controller with public non-parametric methods defined in it call is called a Action.Action is the smallest unit of request.

Action methods must be declared in Controller,this method must be public and non-paremetric.

```java
public class HelloController extends Controller {
    public void index() {
        renderText("This is an action method");
    }
    public void test() {
        renderText("This is an action method");
    }
}
```

Two Actions are declared in above code segement:HelloController.index(),HelloController.test(). In Controller, getPara series methods ,setAttr series methods and render series methods are provided
for Action.





