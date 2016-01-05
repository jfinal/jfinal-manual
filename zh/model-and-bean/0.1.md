JFinal 2.1 新增了 Generator 用来极速生成 Model、BaseModel、MappingKit、DataDictionary 文件。
使用时通常只需配置 Generator 的四个参数即可:baseModelPackageName、 baseModelOutputDir、modelPackageName、modelOutputDir。四个参数分别表示 baseMode 的包名,
baseModel 的输出路径,modle 的包名,model 的输出路径,以下是示例代码:

```java
// base model 所使用的包名
String baseModelPkg = "model.base";
// base model 文件保存路径
String baseModelDir = PathKit.getWebRootPath() + "/../src/model/base";
// model 所使用的包名
String modelPkg = "model";
// model 文件保存路径
String modelDir = baseModelDir + "/..";
Generator gernerator = new Generator(dataSource, baseModelPkg, baseModelDir, modelPkg, modelDir);
gernerator.generate();
```
可在 JFinal 官网下载源码直接用于项目: [www.jfinal.com](http://www.jfinal.com "http://www.jfinal.com")
