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

<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>


<title>Insert title here</title>

</head>
<body>


	 <div class="col-md-4">
                 <div class="panel-body">
                     <table id="tbl-student" class="table table-responsive table-bordered" cellpadding ="0" width="100%">
                         <thead>
                             <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                    <th>Password</th>
                                    <th>Address</th>
                                    <th>Contact</th>
                             </tr>  
                            
                             <%  
 
                             List<Employee> list=EmployeeDao.getAllEmployees();

                                  //String query = "select * from records";
                                  
                                    
                                        for(Employee e : list )
                                        {
                                            int id = e.getId();
                                   %>
            
                             <tr>
                                 <td><%=e.getfName() %></td>
                                 <td><%=e.getlName() %></td>
                                 <td><%=e.getUname() %></td>
                                 
                                 <td><%=e.getPass() %></td>
                                 <td><%=e.getAddr() %></td>
                                 <td><%=e.getContact() %></td>
                                 
                                 
                                 <td><a href="update.jsp?id=<%=id%>">Edit</a></td>
                                 <td><a href="DeleteData.jsp?id=<%=id%>">Delete</a></td>
                             </tr>
                            
                            
                                <%
                                
                                 }
                               %>
                            
                     </table>    
                 </div>
 
            </div>  

					<p><a href="Hello.jsp">ADD</a></p>
  
 

</body>
</html>