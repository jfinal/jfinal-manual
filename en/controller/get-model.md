#getModel 系列方法

getModel 用来接收页面表单域传递过来的 model 对象,表单域名称以”modelName.attrName” 方式命名,除了支持 JFinal 的 Model 对象以外,getModel 同时也支持传统的 Java Bean。以下 是一个简单的示例:

```java
// 定义Model,在此为Blog
public class Blog extends Model<Blog> {
    public static final Blog me = new Blog();
}
```

```xml
// 在页面表单中采用modelName.attrName形式为作为表单域的name
<form action="/blog/save" method="post">
  <input name="blog.title" type="text">
  <input name="blog.content" type="text">
  <input value="提交" type="submit">
</form>
```

```java
public class BlogController extends Controller {
    public void save() {
    // 页面的modelName正好是Blog类名的首字母小写
    Blog blog = getModel(Blog.class);
// 如果表单域的名称为 "otherName.title"可加上一个参数来获取
    blog = getModel(Blog.class, "otherName");
    }
}
```

上面代码中,表单域采用了”blog.title”、”blog.content”作为表单域的 name 属性,”blog”是 类文件名称”Blog”的首字母变小写,”title”是 blog 数据库表的 title 字段,如果希望表单域使用 任意的 modelName,只需要在 getModel 时多添加一个参数来指定,例如: getModel(Blog.class, ”otherName”)。
