#Associated table Operations

JFinal ActiveRecord support associated table operations naturaly naturally, which means nothing new to learn.
There are two methods for associated table operations and the first one is that getting associated table data using SQL directly. The second one is that adding method into `Model` which is used to get associate table data.

Assume there are two tables in database: user, blog  and the relationship between user and blog is one-to-many and blog table have  user_id column to associate to user table.

The first method to get user_name is shown as bellow:

```java
public void relation() {
    String sql = "select b.*, u.user_name from blog b inner join user u on b.user_id=u.id where b.id=?";
    Blog blog = Blog.dao.findFirst(sql, 123);
    String name = blog.getStr("user_name");
}
```

The second method to get associated User in Blog and get associated Blog in User is shown as bellow:

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
