#Db+Record Model original created by JFinal

`Db` class and related `Record` class provide richer database operations beyond `Model` class. When using `Db` and `Record` classes,mapping to tables in database is no longer necessary. `Record` is equivalent to generic `Model`. The commonly-used usage of `Db + Record` model are shown as follows:

```java
// Create an record, whose name attribute is James and age attribute is 25,and add into database.
Record user = new Record().set("name", "James").set("age", 25);
Db.save("user", user);

// Delete the `User` whose id is 25
Db.deleteById("user", 25);

// Retrive the User, whose id is 25, and modify name attribute to James and update into database.
user = Db.findById("user", 25).set("name", "James");
Db.update("user", user);

// Retrive the User whose id is 25 and only need name and age attributes.
user = Db.findById("user", 25, "name, age");

// Get the name attribute of user.
String userName = user.getStr("name");

// Get the age attribute of user.
Integer userAge = user.getInt("age");

// Retrive all the users whose age are grater than 18.
List<Record> users = Db.find("select * from user where age > 18");

// Paged query the users whose age are greater than 18,in the conditions where current page number id 1 and 10 users per page.
Page<Record> userPage = Db.paginate(1, 10, "select *", "from user where http://ww
age > ?", 18);
```
The usage of transaction is shown as bellow:

```java
boolean succeed = Db.tx(new IAtom(){
    public boolean run() throws SQLException {
        int count = Db.update("update account set cash = cash - ? where id = ?", 100, 123);
        int count2 = Db.update("update account set cash = cash + ? where id = ?", 100, 456);
        return count == 1 && count2 == 1; }});
```
The two operations of upgrading database are executed in one transaction and if any exception takes place or false returned by `invoke()` method, this trasaction would rollback automatically.
