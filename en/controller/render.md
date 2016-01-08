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
|renderFreeMarker(”test.html”) |渲染名为 test.html 的视图,且视图类型为 FreeMarker。  |
|renderJsp(”test.html”)|渲染名为 test.html 的视图,且视图类型为 Jsp。  |
|renderVelocity(“test.html”)|渲染名为 test.html 的视图,且视图类型为 Velocity。|
|renderJson()|将所有通过 Controller.setAttr(String, Object)设置 的变量转换成 json 数据并渲染。|
|renderJson(“users”, userList)|以”users”为根,仅将 userList 中的数据转换成 json 数据并渲染。|
|renderJson(user)|将 user 对象转换成 json 数据并渲染。|
|renderJson(“{\”age\”:18}” )|直接渲染 json 字符串。|
|renderJson(new String[]{“user”, “blog”})|仅将 setAttr(“user”, user)与 setAttr(“blog”, blog)设 置的属性转换成 json 并渲染。使用 setAttr 设置的 其它属性并不转换为 json。|
|renderFile(“test.zip”);|渲染名为 test.zip 的文件,一般用于文件下载|
|renderText(“Hello JFinal”)|渲染纯文本内容”Hello JFinal”。|
|renderHtml(“Hello Html”)|渲染 Html 内容”Hello Html”。|
|renderError (404 , “test.html”)|渲染名为 test.html 的文件,且状态为 404。|
|renderError (500 , “test.html”)|渲染名为 test.html 的文件,且状态为 500。|
|renderNull()|不渲染,即不向客户端返回数据。|
|render(new XmlRender())|使用自定义的 XmlRender 来渲染。|


- Because IE do not support contentType is application/json,IE notice to download file when return json after file upload completed, the solution is using render(new JsonRender(params).forIE()).

- Except renderError method, program do not return directly after invoking render series methods, you can use return statement if you want to return directly.Only the last method calls of render method is
valid in several method calls in a action
