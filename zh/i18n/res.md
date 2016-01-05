#I18n与Res

I18n 对象可通过资源文件的 baseName 与 locale 参数获取到与之相对应的 Res 对象,Res 对象提供了 API 用来获取国际化数据。

以下给出具体使用步骤:

- 创建 i18n_en_US.properties、i18n_zh_CN.properties 资源文件,i18n 即为资源文件的
baseName,可以是任意名称,在此示例中使用”i18n”作为 baseName
- i18n_en_US.properties 文件中添加如下内容
msg=Hello {0}, today is{1}.
- i18n_zh_CN.properties 文件中添加如下内容
msg=你好{0}, 今天是{1}.
- 在YourJFinalConfig中使用me.setI18nDefaultBaseName("i18n")配置资源文件默认baseName
- **特别注意,**java 国际化规范要求 properties 文件的编辑需要使用专用的编辑器,否则会出
乱码,常用的有 Properties Editor,在此可以下载:http://www.oschina.net/p/properties+editor

以下是基于以上步骤以后的代码示例:

```java
// 通过locale参数en_US得到对应的Res对象
Res resEn = I18n.use("en_US");
// 直接获取数据
String msgEn = resEn.get("msg");
// 获取数据并使用参数格式化
String msgEnFormat = resEn.format("msg", "james", new Date());
// 通过locale参数zh_CN得到对应的Res对象
Res resZh = I18n.use("zh_CN");
// 直接获取数据
String msgZh = resZh.get("msg");
// 获取数据并使用参数格式化
String msgZhFormat = resZh.format("msg", "詹波", new Date());
// 另外,I18n还可以加载未使用me.setI18nDefaultBaseName()配置过的资源文件,唯一的不同是
// 需要指定baseName参数,下面例子需要先创建otherRes_en_US.properties文件
Res otherRes = I18n.use("otherRes", "en_US");
otherRes.get("msg");
```
