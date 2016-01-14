#render Series Methods

render series methods will render different types of views and return to client. Currently Jfinal can support follwing view types: FreeMarker,JSP,Velocity,JSON,File,Text,Html ,etc. Except view types supported by JFinal,it is  available to extend Render abstract class to exntend  new view types infinitely.

 Normally we use Controller.render(String) method to render a view, the view type when using this method is decided by constants.setViewType(ViewType) in JFinalConfig.configConstant(Constants constants) config,viewTypes which are supported by this method are: Freemarker,JSP,Velocity, default setting is FreeMarker if
configuration is not setted.

Besides,you can configue the view used by `Controller.render(String)` via `constants.setMainRenderFactory(IMainRenderFactory)`. `IMainRenderFactory` is used to extend `Controller.render(String)` method to support views except FreeMarker、JSP、Velocity.




Suppose in JFinalConfig.configRoute(Routes routes),following Controller mapping configuration are included:
route.add("/user",UserController.calss,"/path").
render(String view) usage examples:

|Method Invocation   |Description   |
|----------|-------|
|render("test.html")| Render a view named test.html and the full path of the view is '/path/test.html'|
|render("/other_path/test.html") |Render a view named test.html ant the full path of the view is '/other_path/test.html',which means absolute path is used when parameter starts with '/'|

Usage of other render methods are as follows:

|Method Invocation   |Description |
|---|---|
|renderFreeMarker(”test.html”) |Render a view named test.html and the type is FreeMarker. |
|renderJsp(”test.html”)|Render a view named test.html and the type is JSP. |
|renderVelocity(“test.html”)|Render a view named test.html and the type is Velocity. |
|renderJson()|Render a json with data passed by `Controller.setAttr(String, Object)`|
|renderJson(“users”, userList)|Take 'users' as root,only convert data in userList to json then render them|
|renderJson(user)|Render json data converted from a user object.|
|renderJson(“{\”age\”:18}” )|Render a json string directly.|
|renderJson(new String[]{“user”, “blog”})|Only convert data passed by `setAttr(“user”, user)` and `setAttr(“blog”, blog)` to json then render them|
|renderFile(“test.zip”);|Render a file named test.zip ,normally used in file download.|
|renderText(“Hello JFinal”)|Render a plain text and the content is 'Hello JFinal'.|
|renderHtml(“Hello Html”)|Render a html and the content is 'Hello Html'|
|renderError (404 , “test.html”)|Render a file namely test.html and the status is 404.|
|renderError (500 , “test.html”)|Render a file namely test.html and the status is 500.|
|renderNull()|Do not render,i.e., do not return data to client.|
|render(new XmlRender())|Use user-defined XmlRender to render.|


- Because IE do not support contentType is application/json,IE notice to download file when return json after file upload completed, the solution is using render(new JsonRender(params).forIE()).

- Except renderError method, program do not return directly after invoking render series methods, you can use return statement if you want to return directly.Only the last method calls of render method is
valid in several method calls in a action
