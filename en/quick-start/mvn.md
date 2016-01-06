#Maven下开发
If you use Maven to manage dependencies, only need to add dependency below:

```xml
<dependency>
  <groupId>com.jfinal</groupId>
  <artifactId>jfinal</artifactId>
  <version>2.1</version>
</dependency>
```
Start JFinal in Maven is basically the same as that in non-Maven enviroment, the only
difference is that input `src/main.webapp 80/5` argument in `Program arguments` of `Arguments` tab to specify root foler of the web project when creating start configuration for Java Application. The start method of main method is as follow:

```java
public static void main(String[] args) {
  JFinal.start("src/main/webapp", 80, "/", 5);
}
```
