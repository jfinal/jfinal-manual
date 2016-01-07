#Validator
`Validator` itself has implement `Interceptor` interface, so it also is a interceptor,whose configuration model is the totally the same as validator.Following code is an example of `Validator`:

```java
public class LoginValidator extends Validator {
    protected void validate(Controller c) {
        validateRequiredString("name", "nameMsg", "Please type usernmae");
        validateRequiredString("pass", "passMsg", "Please type password");
}
    protected void handleError(Controller c) {
        c.keepPara("name");
        c.render("login.html");
    }
}
```
`validateXxx(...)`series methods could be invoked in `protected void validator(Controller c)` to validate back-end.

In `protected void handleError(Controller c)`, `c.keepPara(...)` method could be invoked to return value submitted by request to view to keep original input values.

Moreover, `c.render(...)` could be invoked to render corresponding page.

**NOTE** `handleError(Controller c)` only could be invoked when validation fails.

In above code, `keepXxx` in `handleError` method  is used to keep values from form and pass them back to view, in order to avoid users inputing form fields again which have already validated. If `model` object is passed, `keepModel` could be used to keep data inputed by users.
