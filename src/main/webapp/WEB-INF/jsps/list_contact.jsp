<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
     <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Contacts</title>
</head>
<body>
<h2> ALL | Contacts</h2>

<hr>

<table border="2">
    <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Mobile</th>
          <th>Source</th>
          <th>Generate Billing</th>
    </tr>
    <c:forEach var="contacts" items="${contacts}">
    <tr>
        
         <td><a href="contactinfo?id=${contacts.id}">${contacts.firstName}</a></td>
         <td>${contacts.lastName}</td>
         <td>${contacts.email}</td>
         <td>${contacts.mobile}</td>
         <td>${contacts.source}</td>
         <td><a href="billingform?id=${contacts.id}">Billing</a></td>
    </tr>
    
    </c:forEach>


</table>


</body>

</html>