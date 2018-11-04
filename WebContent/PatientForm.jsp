<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>New Hospital Application</title>
</head>
<body>
	<center>
		<h1>Hospital Management</h1>
        <h2>
        	<a href="new">Add New Patient</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Patients</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${patient != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${patient == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${patient != null}">
            			Edit Patient
            		</c:if>
            		<c:if test="${patient == null}">
            			Add New Patient
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${patient != null}">
        			<input type="hidden" name="id" value="<c:out value='${patient.id}' />" />
        		</c:if>            
            <tr>
                <th>FirstName: </th>
                <td>
                	<input type="text" name="firstname" size="45"
                			value="<c:out value='${patient.firstname}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>LastName: </th>
                <td>
                	<input type="text" name="lastname" size="45"
                			value="<c:out value='${patient.lastname}' />"
                	/>
                </td>
            </tr>
			<tr>
                <th>Address: </th>
                <td>
                	<input type="text" name="address" size="45"
                			value="<c:out value='${patient.address}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>City: </th>
                <td>
                	<input type="text" name="city" size="45"
                			value="<c:out value='${patient.city}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Mobile: </th>
                <td>
                	<input type="text" name="mobile" size="45"
                			value="<c:out value='${patient.mobile}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
