<%@page import="emp.EmployeeServlet"%>
<%@page import="dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
    
    <%@ page import="EmployeeModel.Employee" %>
    <%@ page import="dao.EmployeeDao" %>
    <%@ page import="java.util.List" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	int id=Integer.parseInt(request.getParameter("id"));
	int no=EmployeeDao.deleteData(id);
	
	out.println("ROW AT ID "+no+" DELETED");

%>
	<p><a href="List.jsp">Click Back</a></p>

</body>
</html>