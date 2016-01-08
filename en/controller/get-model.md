#getModel series methods

`getModel` is used to accept `model` object passwd from form fields follow the format 'modelName.attrName'.Except supporting JFinal' Model, `getModel` support traditional Java Bean as well. The following code is a simple example:

```java
// Define a Model named Blog
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

In above code, form fields have take 'blog.title', 'blog.content' as as name attribute in form fields, 'blog' is the class name of "Blog", 'title' is the title column of blog table.
If you need any other `modelName`, only need to add one more parameter in `getModel`, e.g., `getModel(Blog.class,'otherName')`.
