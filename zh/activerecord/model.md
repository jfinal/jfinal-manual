#Model

Model是ActiveRecord中最重要的组件之一，它充当MVC模式中的Model部分。以下是Model定义示例代码：

```java
public class User extends Model<User> {
        public static final User dao = new User();
}
```

以上代码中的User通过继承Model，便立即拥有的众多方便的操作数据库的方法。在User中声明的dao静态对象是为了方便查询操作而定义的，该对象并不是必须的。基于ActiveRecord的Model无需定义属性，无需定义getter、setter方法，无需XML配置，无需Annotation配置，极大降低了代码量。

以下为Model的一些常见用法：

```java
// 创建name属性为James,age属性为25的User对象并添加到数据库
new User().set("name", "James").set("age", 25).save();

// 删除id值为25的User
User.dao.deleteById(25);

// 查询id值为25的User将其name属性改为James并更新到数据库
User.dao.findById(25).set("name", "James").update();

// 查询id值为25的user, 且仅仅取name与age两个字段的值
User user = User.dao.findById(25, "name, age");

// 获取user的name属性
String userName = user.getStr("name");

// 获取user的age属性
Integer userAge = user.getInt("age");

// 查询所有年龄大于18岁的user
List<User> users = User.dao.find("select * from user where age>18");

// 分页查询年龄大于18的user,当前页号为1,每页10个user
Page<User> userPage = User.dao.paginate(1, 10, "select *", "from user where age > ?", 18);
```
<span style='color:red'>
特别注意：User中定义的 public static final User dao对象是全局共享的，只能用于数据库查询，不能用于数据承载对象。数据承载需要使用new User().set(…)来实现。
</span>
