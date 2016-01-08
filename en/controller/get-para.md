#getPara series methods

  Controller provide getPara series methods to retrive parameters from request. GetPara series methods fall into two categories. The first category is getPara series methods whose first parameter is String.This series method is a encapsulation of HttpServletRequest.getParameter(String name). The second category is getPara series method whose first parameter is int or non-parametric.
  This series method is used to retrive parameters carried over by urlPara. GetParaMap and getParaNames  match to getParameterMap and  getParaMeterNames of HttpServletRequest.
  

<font coler='red'>Memory tips: The first parameter whose type is String  will get the value of form or question mark with parameter in url.
The first parameter whose type is int or non-parametric will get parameter value in urlPara</font>


Usage example of `getPara` shown as below:

|Method Invocation  |Return Value  |
|-------------------|--------------|
|getPara("title")   |Return param named 'title' in form fields|
|getParaToInt(”age”)|Return param named 'age' in form fields and coverts to int type|
|getPara(0)         |Return first parameter of urlPara in request URL,e.g.,http://localhost/controllerKey/method/v0-v1-v2 would return 'v0'|
|getParaToInt(1)    |Return the second parameter of urlPara in request URL and converts to int type,e.g., http://localhost/controllerKey/method/2-5-9 would return 5|
|getParaToInt(2)    |http://localhost/controllerKey/method/2-5-N8 would return -8。<font color='red'>NOTE: letters N and n could representfor negative sign, which is quite useful when `urlParaSeparator` is '`-`'</font>|
|getPara()|Return the entire value in URL, e.g., http://localhost/controllerKey/method/v0-v1-v2 would return 'v0-v1-v2'|
