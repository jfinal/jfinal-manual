#表关联操作

JFinal ActiveRecord 天然支持表关联操作，并不需要学习新的东西，此为无招胜有招。表关联操作主要有两种方式：一是直接使用sql得到关联数据；二是在Model中添加获取关联数据的方法。

假定现有两张数据库表：user、blog，并且user到blog是一对多关系，blog表中使用user_id关联到user表。如下代码演示使用第一种方式得到user_name：

```java
public void relation() {
    String sql = "select b.*, u.user_name from blog b inner join user u on b.user_id=u.id where b.id=?";
    Blog blog = Blog.dao.findFirst(sql, 123);
    String name = blog.getStr("user_name");
}
```
以下代码演示第二种方式在Blog中获取相关联的User以及在User中获取相关联的Blog：

```java
public class Blog extends Model<Blog>{
    public static final Blog dao = new Blog();

    public User getUser() {
        return User.dao.findById(get("user_id"));
    }
}
public class User extends Model<User>{
    public static final User dao = new User();

    public List<Blog> getBlogs() {
        return Blog.dao.find("select * from blog where user_id=?", get("id"));
    }
}
```
