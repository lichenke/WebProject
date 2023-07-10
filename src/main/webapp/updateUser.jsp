<%--
  Created by IntelliJ IDEA.
  User: lichenke
  Date: 2023/7/4
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js" integrity="sha512-3gJwYpMe3QewGELv8k/BX9vcqhryRdzRMxVfq6ngyWXwo03GFEzjsUm8Q7RZcHPHksttq7/GFoxjCVUjkjvPdw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<div>
  <form action="user" method="post">

    <input type="hidden" name="uid" value="${user.id}"/>
    <input type="hidden" name="type" value="update_" />

    <table>
      <tr>
        <td>用户名：</td>
        <td><input type="text" disabled="disabled" name="username" value="${user.name}"/></td>
      </tr>
      <tr>
        <td>密码：</td>
        <td><input type="text" name="password" value="${user.pwd}"/></td>
      </tr>
      <tr>
        <td><input type="submit" value="更新"/></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
