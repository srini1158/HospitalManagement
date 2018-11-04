<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<center>
	<h1>Login page</h1>
</center>
<div align="center">
<form action="login" method ="post">
<table border="1" cellpadding="5">
	<tr>
       <th>UserName: </th>
       <td>
       		<input type="text" name="user" required="required" size="45"
              value="<c:out value='${login.username}' />"
       		/>
       </td>
    </tr>
    <tr>
       <th>Password: </th>
       <td>
             <input type="text" name="password" required="required" size="45"
                	value="<c:out value='${login.password}' />"
             />
       </td>
    </tr>
    <tr>
       <td colspan="2" align="center">
           <input type="submit" value="Login" />
       </td>
    </tr>
</table>
</form>
</div>
</body>
</html>