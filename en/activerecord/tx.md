#Declarative Transactions

ActiveRecord supports declarative transactions, which need to use `ActionRecordPlugin` to realize. View `Interceptor`-related chapters to see how to configure interceptors.
The demo usage of declarative transaction is shown as bellow:



```java
//This case is only for demonstration, some bussion logic like account status are not considered strictly.
@Before(Tx.class)
public void trans_demo() {
// Get the transfer amount.
Integer transAmount = getParaToInt("transAmount");
// Get the id of transfer-out
Integer fromAccountId = getParaToInt("fromAccountId");
// Get the id of transfer-in
Integer toAccountId = getParaToInt("toAccountId");
// Transfer out
Db.update("update account set cash = cash - ? where id = ?",
              transAmount, fromAccountId);
// Transfer in
Db.update("update account set cash = cash + ? where id = ?",
}

```
In above code, only a `Tx` interceptor is declared to add transaction support.
Besides, `ActiveRecord` is equipped with ` TxByRegex`, `TxByActionKeys`, `TxByMethods` to support regex(regular expression), actionKeys, actionMethods declarative transactions respectively, demo code is shown as bellow:


```java
public void configInterceptor(Interceptors me) {
    me.add(new TxByRegex(".*save.*"));
    me.add(new TxByActionKeys("/cash/trans", "/other"));
    me.add(new TxByMethods("save", "update"));
}
```
In above case,`TxByRegex` interceptor can intercept `action`s via regular expression passed in and transaction would be open when `actionKey` is matched by regular expression.

`TxByActionKeys` can intercept `action`s for specific `actionKey` and open transactions.
`TxByMethods` can intercept `action`s for specific methods and open transactions.



<span style='color:red'>Note: MySql database only support transactions for InnoDB engine,not support MyISAM.</span>
