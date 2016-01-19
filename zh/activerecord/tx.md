#声明式事务

ActiveRecord 支持声名式事务,声明式事务需要使用 ActiveRecordPlugin 提供的拦截器来
实现,拦截器的配置方法见 Interceptor 有关章节。以下代码是声明式事务示例:

```java
// 本例仅为示例, 并未严格考虑账户状态等业务逻辑 
@Before(Tx.class)
public void trans_demo() {
// 获取转账金额
Integer transAmount = getParaToInt("transAmount");
// 获取转出账户id
Integer fromAccountId = getParaToInt("fromAccountId");
// 获取转入账户id
Integer toAccountId = getParaToInt("toAccountId");
// 转出操作
Db.update("update account set cash = cash - ? where id = ?",
              transAmount, fromAccountId);
// 转入操作
Db.update("update account set cash = cash + ? where id = ?",
}

```

以上代码中,仅声明了一个 Tx 拦截器即为 action 添加了事务支持。除此之外 ActiveRecord 还配备了 TxByRegex、TxByActionKeys、TxByMethods,分别支持 regex(正则)、actionKeys、 actionMethods 声明式事务,以下是示例代码:

```java
public void configInterceptor(Interceptors me) {
    me.add(new TxByRegex(".*save.*"));
    me.add(new TxByActionKeys("/cash/trans", "/other"));
    me.add(new TxByMethods("save", "update"));
}
```

上例中的 TxByRegex 拦截器可通过传入正则表达式对 action 进行拦截,当 actionKey 被正 则匹配上将开启事务。TxByActionKeys 可以对指定的 actionKey 进行拦截并开启事务, TxByMethods 可以对指定的 method 进行拦截并开启事务。

<span style='color:red'>注意:MySql 数据库表必须设置为 InnoDB 引擎时才支持事务,MyISAM 并不支持事务。</span>
