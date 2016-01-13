#Composite Primary Key

JFinal `ActiveRecordPlugin` support composite primary key using minimal design after 2.0 version. For `Model`, the name of composite primary key should be specified when mapping `Model`s, the detailed useage is shown as bellow:

```java
ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
// The configuration of multiple datasources only need to specify composite primary key name in the second parameter.

arp.addMapping("user_role", "userId, roleId", UserRole.class);

// Specific composite primary key simultaneously to retrive data.
UserRole.dao.findById(123, 456);

// Specific composite primary key simultaneously to delete data.
UserRole.dao.deleteById(123, 456);
```

As shown in above code, for `Model`, only need to specify composite primary key name when mapping the `Model`. In the  subsequent operations, JFinal would verify the number that composite primary key supports, exception would be through out when the number of composite primary keys are not correct, specially when the number of composite primary key can not guarantee data security.

The number of composite primary key are not limited to 2, it could be any number that the database support.


For Db + Record model, need no configuration for composite primary key, use it directly.


```java
Db.findById("user_role", "roleId, userId", 123, 456);
Db.deleteById("user_role", "roleId, userId", 123, 456);
```
