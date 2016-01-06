#Freemarker 示例

以下代码为 FreeMarker 经常使用的指令与插值:

```html
<table>
  <#list userList as user>
    <tr>
     <td>${user.name}</td>
     <td>${user.age}</td>
     <td>${user.email}</td>
   </tr>
  </#list>
</table>
```

以上代码将 userList 中的 user 对象循环输出。
