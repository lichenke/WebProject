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
    <title>请注册</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js" integrity="sha512-3gJwYpMe3QewGELv8k/BX9vcqhryRdzRMxVfq6ngyWXwo03GFEzjsUm8Q7RZcHPHksttq7/GFoxjCVUjkjvPdw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<div>
  <form action="register" method="post">
    <table>
      <tr>
        <td>用户名：</td>
        <td>
          <input type="text" name="username"/>
          <label id="nameLabel" style="color: red"></label>
          
          <script>
            $(function () {
              $("input[name='username']").change(function () {
                let name = $(this).val();
                $.ajax({
                  url:"check",
                  data:{"username": name},
                  type:"post",
                  success:function (data) {
                    if (data === 'true') {
                      $("#nameLabel").text("用户名太受欢迎, 请换一个");
                    } else {
                      $("#nameLabel").text("");
                    }
                  }
                })
              })
            })
          </script>
        </td>
      </tr>
      <tr>
        <td>密码：</td>
        <td><input type="password" name="password"/></td>
      </tr>
      <tr>
        <td>确认密码：</td>
        <td><input type="password" name="confirm"/></td>
      </tr>
      <tr>
        <td><a href="login.jsp">已有账号?去登录</a></td>
      </tr>
      <tr>
        <td>
          <label style="color: red">${errorMsg}</label>
        </td>
      </tr>

      <tr>
        <td><input type="submit" value="注册"/></td>
        <td><input type="reset" value="重置"/></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
