#Model

Model is one of the most important component of ActiveRecord,it is the Model of MVC architecture. Following code is the usage of Model definition:


```java
public class User extends Model<User> {
        public static final User dao = new User();
}
```
User in above code immediately has many convenient operation of the database by inheritance.
Dao static object declared in User is defined in order to make search operation easy,but not necessary. ActiveRecord-based Model which does not need to define attributes,no need to define getter,setter methods, no XML configuration,no Annotation configuration, reduce amount of code greatly.

Some commonly used methods of Model are as follows:

```java
// Create an object,whose name attribute is James and age attribute is 25,and add into database.
new User().set("name", "James").set("age", 25).save();

// Delete the `User` whose id is 25
User.dao.deleteById(25);

// Retrive the User, whose id is 25, and modify name attribute to James and update into database.
User.dao.findById(25).set("name", "James").update();

// Retrive the User whose id is 25 and only need name and age attributes.
User user = User.dao.findById(25, "name, age");

// Get the name attribute of user.
String userName = user.getStr("name");

// Get the age attribute of user.
Integer userAge = user.getInt("age");

// Retrive all the users whose age are grater than 18.
List<User> users = User.dao.find("select * from user where age>18");

// Paged query the users whose age are greater than 18,in the conditions where current page number id 1 and 10 users per page.

Page<User> userPage = User.dao.paginate(1, 10, "select *", "from user where age > ?", 18);
```
<span style='color:red'>
NOTE: Public static final User dao object defined in User is shared in global, is just used to search database, not used as a object storing data.If you need to store data,use new User().set(...).
</span>
