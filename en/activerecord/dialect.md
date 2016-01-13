#Dialect Multi-db support
Currently ActiveRecordPlugin has provided MysqlDialect,OracleDialect,AnsiSqlDialect implement classes. MysqlDialet and OracleDialect respectively implement the support for Mysql and Oracle,AnsiSqlDialect implements the support of database who follows ANSI SQL.Following code is the configuration code of database dialect:

```java
public class DemoConfig extends JFinalConfig {
    public void configPlugin(Plugins me) {
    ActiveRecordPlugin arp = new ActiveRecordPlugin(...); me.add(arp);
    // Configure Postgresql dialect
    arp.setDialect(new PostgresqlDialect());
    }
}
```
