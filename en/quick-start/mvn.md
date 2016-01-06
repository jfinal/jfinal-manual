#Maven下开发
如果使用 Maven 管理 jar 包依赖,只需要引入如下 dependency:

```xml
<dependency>
  <groupId>com.jfinal</groupId>
  <artifactId>jfinal</artifactId>
  <version>2.1</version>
</dependency>
```

Manve 下启动 JFinal 与前面介绍的非 maven 方式基本相同,唯一的区别是在创建 Java Application 启动项时,在 Arguments 标签中的 Program arguments 中输入:src/main/webapp 80 / 5 参数用来指定 web 项目的根目录。如下示例代码是 main 方法启动方式:

```java
public static void main(String[] args) {
  JFinal.start("src/main/webapp", 80, "/", 5);
}
```
