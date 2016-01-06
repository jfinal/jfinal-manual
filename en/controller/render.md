#render 系列方法
render 系列方法将渲染不同类型的视图并返回给客户端。JFinal 目前支持的视图类型有: FreeMarker、JSP、Velocity、JSON、File、Text、Html 等等。除了 JFinal 支持的视图型以外, 还可以通过继承 Render 抽象类来无限扩展视图类型。

通常情况下使用 Controller.render(String)方法来渲染视图,使用 Controller.render(String)时
的 视图 类 型 由 JFinalConfig.configConstant(Constants constants) 配 置 中 的 constants. setViewType(ViewType)来决定,该设置方法支持的 ViewType 有:FreeMarker、JSP、Velocity, 不进行配置时的缺省配置为 FreeMarker。

此 外 , 还 可 以 通 过 constants.setMainRenderFactory(IMainRenderFactory) 来 设 置
Controller.render(String)所使用的视图,IMainRenderFactory 专门用来对 Controller.render(String) 方法扩展除了 FreeMarker、JSP、Velocity 之外的视图。


假 设 在 JFinalConfig.configRoute(Routes routes) 中 有 如 下 Controller 映 射 配 置 : routes.add(“/user”, UserController.class, “/path”), render(String view)使用例子:


|方法调用   |描述   |
|---|---|
|render("test.html")   | 渲染名为 test.html 的视图,该视图的全路径 为”/path/test.html”  |
|render("/other_path/test.html") | 渲染名为 test.html 的视图,该视图的全路径 为”/other_path/test.html”,即当参数以”/”开头时将 采用绝对路径。|

其他render方法使用例子：


|方法调用   |描述   |
|---|---|
|renderFreeMarker(”test.html”) |渲染名为 test.html 的视图,且视图类型为 FreeMarker。  |
| renderJsp(”test.html”)|渲染名为 test.html 的视图,且视图类型为 Jsp。  |
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


- IE 不支持 contentType 为 application/json,在 ajax 上传文件完成后返回 json 时 IE 提示下载文 件 , 解 决 办 法 是 使 用 : render(new JsonRender().forIE()) 或 者 render(new JsonRender(params).forIE())。这种情况只出现在 IE 浏览器 ajax 文件上传,其它普通 ajax 请求 不必理会。




- 除 renderError 方法以外,在调用 render 系列的方法后程序并不会立即返回,如果需要立即 返回需要使用 return 语句。在一个 action 中多次调用 render 方法只有最后一次有效。
