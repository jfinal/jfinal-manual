#Freemarker Demo

Following code is the commond and interpolation commonly used by FreeMarker.

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

The code shown above would print user object in userList
