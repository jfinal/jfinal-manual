#I18ninterceptor

I18nInterceptor 拦截器是针对于 web 应用提供的一个国际化组件,以下是在 freemarker 模板 中使用的例子:

```java
//先将I18nInterceptor配置成全局拦截器
public void configInterceptor(Interceptors me) {
    me.add(new I18nInterceptor());
}
// 然后在freemarker中即可通过_res对象来获取国际化数据
${_res.get("msg")}
```

以上代码通过配置了 I18nInterceptor 拦截 action 请求,然后即可在 freemarker 模板文件中 通过名为_res 对象来获取国际化数据,I18nInterceptor 的具体工作流程如下:

- 试图从请求中通过 controller.getPara(“_locale”)获取 locale 参数,如果获取到则将其保存到
cookie 之中
http://www.jfinal.com
-如果 controller.getPara(“_locale”)没有获取到参数值,则试图通过 controller.getCookie(“_locale”)得到 locale 参数
- 如果以上两步仍然没有获取到 locale 参数值,则使用 I18n. defaultLocale 的值做为 locale 值 来使用
- 使用前面三步中得到的 locale 值,通过 I18n.use(locale)得到 Res 对象,并通过 controller.setAttr(“_res”, res)将 Res 对象传递给页面使用
- 如果 I18nInterceptor. isSwitchView 为 true 值的话还会改变 render 的 view 值,实现整体模板 文件的切换,详情可查看源码。

以上步骤 I18nInterceptor 中的变量名”_locale”、”_res”都可以在创建 I18nInterceptor 对象时 进行指定,不指定时将使用默认值。还可以通过继承 I18nInterceptor 并且覆盖 getLocalPara、 getResName、getBaseName 来定制更加个性化的功能。

在有些 web 系统中,页面需要国际化的文本过多,并且 css 以及 html 也因为国际化而 大不相同,对于这种应用场景先直接制做多套同名称的国际化视图,并将这些视图以 locale 为 子目录分类存放,最后使用I18nInterceptor拦截器根据 locale 动态切换视图,而不必对视图中 的文本逐个进行国际化切换,只需将 I18nInterceptor.isSwitchView 设置为 true 即可,省时省力。
