package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EmployeeModel.Employee;
import dao.EmployeeDao;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public EmployeeServlet() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");

        Employee employee = new Employee();
        employee.setfName(firstName);
        employee.setlName(lastName);
        employee.setUname(username);
        employee.setPass(password);
        employee.setContact(contact);
        employee.setAddr(address);
        
        int status=0;
        try {
        	//EmployeeDao empDao=new EmployeeDao();
             status=EmployeeDao.registerEmployee(employee);
            System.out.println("STATUS UPDATE "+status+" employee added");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        response.sendRedirect("List.jsp");
        
		/*
		 * out.println("List Of Employees"); List<Employee>
		 * list=EmployeeDao.getAllEmployees(); for(Employee e : list) {
		 * out.println(e.getId()); out.println(e.getfName()); out.println(e.getlName());
		 * out.println(e.getUname()); out.println(e.getPass());
		 * out.println(e.getAddr()); out.println(e.getContact()); }
		 */
        
        //response.sendRedirect("employeedetails.jsp");
        /*if(status>0){  
            out.println("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("Hello.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  */
        
		

	}

}
