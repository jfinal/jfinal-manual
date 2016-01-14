#Rapid Experience with Generator
In JFinal 2.1, Generator is added in to quickly generate `Model`, `BaseModel`, `MappingKit`, `DataDictionary` files.
Only need to configure 4 parameters including `baseModelPackageName`, `baseModelOutputDir`, `modelPackageName`, `modelOutputDir` when using. These 4 parameters stand for package name used by `BaseMode`, path to save `BaseModel`, package name used by `Model`, path to save `Model` files respectively, the demo usage is shown as bellow:

```java
// Package name used by BaseModel
String baseModelPkg = "model.base";
// Path to save BaseModel
String baseModelDir = PathKit.getWebRootPath() + "/../src/model/base";
// Package name used by Model
String modelPkg = "model";
// Path to save Model files
String modelDir = baseModelDir + "/..";
Generator gernerator = new Generator(dataSource, baseModelPkg, baseModelDir, modelPkg, modelDir);
gernerator.generate();
```
You can download source code to use in your project on [www.jfinal.com](http://www.jfinal.com "http://www.jfinal.com").
