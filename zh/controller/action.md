#getPara 系列方法

Controller 提供了 getPara 系列方法用来从请求中获取参数。getPara 系列方法分为两种类型。 第一种类型为第一个形参为 String 的 getPara 系列方法。该系列方法是对 HttpServletRequest.getParameter(String name) 的 封 装 , 这 类 方 法 都 是 转 调 了 HttpServletRequest.getParameter(String name)。第二种类型为第一个形参为 int 或无形参的 getPara 系列方法。该系列方法是去获取 urlPara 中所带的参数值。getParaMap 与 getParaNames 分别对应 HttpServletRequest 的 getParameterMap 与 getParameterNames。
<font coler='red'>记忆技巧:第一个参数为 String 类型的将获取表单或者 url 中问号挂参的域值。第一个参数为 int 或无参数的将获取 urlPara 中的参数值。</font>


getPara 使用例子:

|方法调用  |返回值   |
|---|---|
|getPara("title")   | 返回页面表单域名为“title”参数值  |
|getParaToInt(”age”)|返回页面表单域名为“age”的参数值并转为 int 型|
|getPara(0)|返回 url 请求中的 urlPara 参数的第一个值,如 http://localhost/controllerKey/method/v0-v1-v2 这个请求将 返回”v0”|
|getParaToInt(1)|返回 url 请求中的 urlPara 参数的第二个值并转换成 int 型,如 http://localhost/controllerKey/method/2-5-9 这个请求将返回 5|
|getParaToInt(2)|如http://localhost/controllerKey/method/2-5-N8 这个 请求将返回 -8。<font color='red'>注意:约定字母 N 与 n 可以表示负 号,这对 urlParaSeparator 为 “-” 时非常有用。</font>|
|getPara()|返回 url 请求中的 urlPara 参数的整体值,如 http://localhost/controllerKey/method/v0-v1-v2 这个 请求将返回”v0-v1-v2”|
