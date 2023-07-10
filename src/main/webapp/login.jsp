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
    <title>请登录</title>
</head>
<body>
<div>
  <form action="login" method="post">
    <table>
      <tr>
        <td>
          <label style="color: green">${msg}</label>
        </td>
      </tr>
      <tr>
        <td>用户名：</td>
        <td><input type="text" name="username" value="${username}"/></td>
      </tr>
      <tr>
        <td>密码：</td>
        <td><input type="password" name="password"/></td>
      </tr>
      <tr>
        <td>验证码：</td>
        <td><input type="text" name="vcode"/></td>
        <td><img src="generateCode" /></td>
      </tr>
      <tr>
        <td><a href="register.jsp">没有账号?请注册</a></td>
      </tr>
      <tr>
        <td>
          <label style="color: red">${errorMsg}</label>
        </td>
      </tr>

      <tr>
        <td><input type="submit" /></td>
        <td><input type="reset" /></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
