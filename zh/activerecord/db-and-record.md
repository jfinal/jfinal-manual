#JFInal独创Db+Record模式

Db 类及其配套的 Record 类,提供了在 Model 类之外更为丰富的数据库操作功能。使用 Db 与 Record 类时,无需对数据库表进行映射,Record 相当于一个通用的 Model。以下为 Db + Record 模式的一些常见用法:

```java
// 创建name属性为James,age属性为25的record对象并添加到数据库
Record user = new Record().set("name", "James").set("age", 25);
Db.save("user", user);
// 删除id值为25的user表中的记录
Db.deleteById("user", 25);
// 查询id值为25的Record将其name属性改为James并更新到数据库
user = Db.findById("user", 25).set("name", "James");
Db.update("user", user);
// 查询id值为25的user, 且仅仅取name与age两个字段的值
user = Db.findById("user", 25, "name, age"); // 获取user的name属性
String userName = user.getStr("name");
// 获取user的age属性
Integer userAge = user.getInt("age");
// 查询所有年龄大于18岁的user
List<Record> users = Db.find("select * from user where age > 18");
// 分页查询年龄大于18的user,当前页号为1,每页10个user
Page<Record> userPage = Db.paginate(1, 10, "select *", "from user where http://ww
age > ?", 18);
```

以下为事务处理示例:

```java
boolean succeed = Db.tx(new IAtom(){
    public boolean run() throws SQLException {
        int count = Db.update("update account set cash = cash - ? where id = ?", 100, 123);
        int count2 = Db.update("update account set cash = cash + ? where id = ?", 100, 456);
        return count == 1 && count2 == 1; }});
```

以上两次数据库更新操作在一个事务中执行,如果执行过程中发生异常或者 invoke()方法 返回 false,则自动回滚事务。
