<%@page import="emp.EmployeeServlet"%>
<%@page import="dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
    
    <%@ page import="EmployeeModel.Employee" %>
    <%@ page import="dao.EmployeeDao" %>
    <%@ page import="java.util.List" %>

<%-- 
	<%
    if(request.getParameter("submit")!=null)
    {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        
        Employee emp=new Employee();
        
        emp.setfName(firstName);
        emp.setlName(lastName);
        emp.setUname(username);
        emp.setPass(password);
        emp.setContact(contact);
        emp.setAddr(address);  
        
        int s=EmployeeDao.updateData(id);
        
        %>
   
    <%            
    }
 
%>

 --%>





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		 <form  method="POST" action="#" >
              
                  <% 
                       int id = Integer.parseInt(request.getParameter("id"));
                	   List<Employee> list=EmployeeDao.updateFormList(id);
						

                       for(Employee e : list )
                       {
/*                            int id = e.getId();
 */                  
                  %>
                          
                      <div align="center">
  
  
   <table style="with: 80%;">
    <tr style="padding:20px;">
     <td>First Name</td>
     <td><input type="text" name="firstName" value="<%= e.getfName()%>"/></td>
    </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="lastName" value="<%= e.getlName()%>" /></td>
    </tr>
    <tr>
     <td>UserName</td>
     <td><input type="text" name="username" value="<%= e.getUname()%>" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" value="<%= e.getPass()%>" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="address" value="<%= e.getAddr()%>" /></td>
    </tr>
    <tr>
     <td>Contact No</td>
     <td><input type="text" name="contact" value="<%= e.getContact()%>" /></td>
    </tr>
    
    <%} %>
    
   </table>
   <input type="submit" name="submit" value="Submit" />
  </form>
  <p><a href="List.jsp">Click Back</a></p>
 </div>  
                    
                   
<%

    if(request.getParameter("submit")!=null)
    {
    
	    	
        int idd = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        
        Employee emp=new Employee();
        
        emp.setfName(firstName);
        emp.setlName(lastName);
        emp.setUname(username);
        emp.setPass(password);
        emp.setContact(contact);
        emp.setAddr(address);  
        
        int s=EmployeeDao.updateData(emp,idd);
        //response.sendRedirect("/EmployeeServlet");
        
        %>
   
    <%            
    }
 
%>


</body>
</html>