<%--
  Created by IntelliJ IDEA.
  User: lichenke
  Date: 2023/7/5
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>dashboard</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js" integrity="sha512-3gJwYpMe3QewGELv8k/BX9vcqhryRdzRMxVfq6ngyWXwo03GFEzjsUm8Q7RZcHPHksttq7/GFoxjCVUjkjvPdw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>


<h1>展示用户列表</h1>
<label style="color: red">${msg}</label>
<table>
    <tr>
        <th></th>
        <th>id</th>
        <th>用户名</th>
        <th>用户密码</th>
        <th>操作</th>
    </tr>

    <c:forEach var="user" items="${users}">
        <tr id="tr_${user.id}">
            <td><input type="checkbox" /></td>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.pwd}</td>
            <td>
                <a href="javascript:void(0);" onclick="deleteUser('${user.id}')">删除</a>
                <a href="user?type=update&uid=${user.id}">修改</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>


<script>
    function deleteUser(uid) {
        let el = confirm("确认删除嘛？")
        if (el) {
            $.ajax({
                url:"user",
                data:{"type": "delete", "uid": uid},
                type:"post",
                success:function (data) {
                    if (data === 'true') {
                        let trId = "#tr_" + uid;
                        $(trId).remove();
                    }
                }
            })
        }
    }

</script>

</html>
