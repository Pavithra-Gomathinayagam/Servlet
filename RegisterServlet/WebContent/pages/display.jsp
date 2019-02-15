<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Register Details</h4>
	<table border="1px">
		<%@ page import="com.zilker.bean.Student"%>
		<%@page import="java.util.ArrayList"%>
		<%
			/* ArrayList<Student> list = new ArrayList<Student>();
			list = (ArrayList<Student>) request.getAttribute("stud"); */ 
		%>
		<tr>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>COUNTRY</th>
		</tr>

		<%-- <%
			for (Student student : list) {
		%>
		<tr>
			<td><%=student.getName()%></td>
			<td><%=student.getEmail()%></td>
			<td><%=student.getCountry()%></td>
		</tr>
		<%
			}
		%> --%>
		<%-- <c:forEach var=”list” items=”some variable/expr”> ( do action by accessing ${list} )</c:forEach> --%>
		
		<c:forEach var="st" items="${stud}"> 
		
		<tr>
			<%-- <td><%= st %></td> --%>
			<td><c:out value="${st.name}" /> </td>
			<td><c:out value="${st.email}" /></td>
			<td><c:out value="${st.country}" /></td>
		</tr>
		
		</c:forEach>
		
	</table>


</body>
</html>