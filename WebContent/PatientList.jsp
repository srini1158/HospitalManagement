<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>New Hospital Application</title>
</head>
<body>
	<center>
		<h1>New Hospital Management</h1>
        <h2>
        	<a href="new">Add New Patient</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Patients</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Patients</h2></caption>
            <tr>
                <th>Patient ID</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Address</th>
				<th>City</th>
				<th>Mobile</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="patient" items="${listPatient}">
                <tr>
                    <td><c:out value="${patient.id}" /></td>
                    <td><c:out value="${patient.firstName}" /></td>
                    <td><c:out value="${patient.lastName}" /></td>
					<td><c:out value="${patient.address}" /></td>
                    <td><c:out value="${patient.city}" /></td>
                    <td><c:out value="${patient.mobile}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${patient.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${patient.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
