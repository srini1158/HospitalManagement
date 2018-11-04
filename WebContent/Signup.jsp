<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp Page</title>
</head>
<body>
<center>
	<h1>Signup page</h1>
</center>
<div align="center">
<form action="signup" method ="post">

<table border="1" cellpadding="5">
    <tr>
       <th>FirstName: </th>
       <td>
          <input type="text" name="firstname" size="45"
             value="<c:out value='${signup.firstname}' />"
           />
       </td>
    </tr>
    <tr>
       <th>LastName: </th>
       <td>
          <input type="text" name="lastname" size="45"
              value="<c:out value='${signup.lastname}' />"
           />
       </td>
    </tr>
	<tr>
       <th>Email Id: </th>
       <td>
           <input type="text" name="email" size="45"
             value="<c:out value='${signup.email}' />"
           />
       </td>
    </tr>
	<tr>
       <th>UserName: </th>
       <td>
       		<input type="text" name="user" required="required" size="45"
              value="<c:out value='${signup.username}' />"
       		/>
       </td>
    </tr>
    <tr>
       <th>Password: </th>
       <td>
             <input type="password" name="password" required="required" size="45"
                	value="<c:out value='${signup.password}' />"
             />
       </td>
    </tr>
    <tr>
       <td colspan="2" align="center">
           <input type="submit" value="Signup" />
       </td>
    </tr>
</table>
</form>
</div>
</body>
</html>