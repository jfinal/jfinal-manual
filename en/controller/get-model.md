#getModel series methods

`getModel` is used to accept `model` object passwd from form fields follow the format 'modelName.attrName'.Except supporting JFinal' Model, `getModel` support traditional Java Bean as well. The following code is a simple example:

```java
// Define a Model named Blog
public class Blog extends Model<Blog> {
    public static final Blog me = new Blog();
}
```

```xml
// Use the pattern modelName.attrName in form as the name form fields.
<form action="/blog/save" method="post">
  <input name="blog.title" type="text">
  <input name="blog.content" type="text">
  <input value="submit" type="submit">
</form>
```

```java
public class BlogController extends Controller {
    public void save() {
        //The modelName in form field is just the the uncapitalized name of Blog class.
        Blog blog = getModel(Blog.class);
        //If the name in form field is "otherName.title" pattern, add an extra parameter to get.
        blog = getModel(Blog.class, "otherName");
    }
}
```

In above code, form fields have take 'blog.title', 'blog.content' as as name attribute in form fields, 'blog' is the class name of "Blog", 'title' is the title column of blog table.
If you need any other `modelName`, only need to add one more parameter in `getModel`, e.g., `getModel(Blog.class,'otherName')`.
