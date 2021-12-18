package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import EmployeeModel.Employee;
import emp.EmployeeServlet;


public class EmployeeDao 
{
	
	public static Connection getConnection()
    {  
        Connection con=null;  
        try
        {
        	
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","admin@123");

        }
        catch(Exception e)
        {
        	System.out.println(e);
        }  
        return con;  
    } 	  
	

	
	public static int registerEmployee(Employee employee) throws ClassNotFoundException {
        String insertEmpQuery = "INSERT INTO emp" +
            "  (first_name, last_name, username, password, address, contact) VALUES " +
            " (?,?,?,?,?,?);";

        
        int result = 0;
        

        try 
        {
        	
            Connection connection=EmployeeDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertEmpQuery);
            		
            //preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, employee.getfName());
            preparedStatement.setString(2, employee.getlName());
            preparedStatement.setString(3, employee.getUname());
            preparedStatement.setString(4, employee.getPass());
            preparedStatement.setString(5, employee.getAddr());
            preparedStatement.setString(6, employee.getContact());

            System.out.println(preparedStatement);
           
            result = preparedStatement.executeUpdate();

        } 
        catch (SQLException e) 
        {
        	System.out.println(e);
        }
        return result;
    }
	
	
	public static List<Employee> getAllEmployees(){  
        List<Employee> list=new ArrayList<Employee>();  
          
        try{  
            Connection con=EmployeeDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from emp");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Employee e=new Employee();  
                e.setId(rs.getInt(1));  
                e.setfName(rs.getString(2));  
                e.setlName(rs.getString(3));
                e.setUname(rs.getString(4));
                e.setPass(rs.getString(5));  
                e.setAddr(rs.getString(6));  
                e.setContact(rs.getString(7));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
	
	
	public static List<Employee> updateFormList(int id){  
        List<Employee> updateList=new ArrayList<Employee>();
        try{  
            Connection con=EmployeeDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from emp where id=?");
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Employee e=new Employee();  
                e.setId(rs.getInt(1));  
                e.setfName(rs.getString(2));  
                e.setlName(rs.getString(3));
                e.setUname(rs.getString(4));
                e.setPass(rs.getString(5));  
                e.setAddr(rs.getString(6));  
                e.setContact(rs.getString(7));  
                updateList.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return updateList;  
    }  
	
	public static int updateData(Employee e,int id)
	{
		int status=0;
		System.out.println("INSIDE UPDATE DATAAAAAAAAA");
		System.out.println("IDDD ISSS "+id);
		//Employee e=new Employee();
		Connection con=EmployeeDao.getConnection();
		try {
			System.out.println("INSIDEEEEEE TRYYYYY");
			PreparedStatement ps=con.prepareStatement("update emp set first_name=?,last_name=?,username=?,password=?,address=?,contact=? where id=?");
			ps.setString(1, e.getfName());
			ps.setString(2, e.getlName());
			ps.setString(3, e.getUname());
			ps.setString(4, e.getPass());
			ps.setString(5, e.getAddr());
			ps.setString(6, e.getContact());
			ps.setInt(7, id);
			
			int n=ps.executeUpdate();
			System.out.println("UPDATE STATUS "+n);
			
		} catch (SQLException se) {
			System.out.println(se);
		}
		
		
		return status;
	
	}
	
	public static int deleteData(int id) 
	{
		Connection con=EmployeeDao.getConnection();
		try
		{
			PreparedStatement ps=con.prepareStatement("delete from emp where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		}
		catch (SQLException ex) 
		{	
			System.out.println(ex);
		}
		return id;
	}
	}


