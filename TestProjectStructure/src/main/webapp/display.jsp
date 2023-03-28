<%@page import="com.java.dbConnection.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try
{
Connection connection=ConnectionFactory.getConnection();
Statement statement=connection.createStatement();
ResultSet rs=statement.executeQuery("select * from employee");
%>
<table border="2">
<thead>
<tr><th>Id</th> <th>Name</th> <th>Salary </th>

</tr>
</thead>
<tbody>

<%
while(rs.next())
{%>
<tr><%
	%><td><%out.println(rs.getInt(1));%></td><%
	%><td><%out.println(rs.getString(2));%></td><%
	%><td><%out.println(rs.getFloat(3));%></td><%
}
%>
</tr>
</tbody>
</table>
<%
}
catch (Exception e) {
	System.out.println(e);
}


%>
<form action="AddEmployee.html">
<input type="submit" value="Back">
</form>

</body>
</html>