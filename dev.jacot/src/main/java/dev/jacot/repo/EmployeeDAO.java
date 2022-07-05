package dev.jacot.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.jacot.models.Employee;
import dev.jacot.util.ConnectionUtil;

public class EmployeeDAO 
{
	
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> employees = new ArrayList<>();
		
		String sql = "select * from employee";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("employee_id");
				
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String username = rs.getString("username");
				String password = rs.getString("pass");
				
				Employee e = new Employee(password, username, lastName, firstName,id);
				
				employees.add(e);
				
			}
			
			return employees;
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Employee getEmployeeById(int id)
	{
		String sql = "select * from employee where id = ?";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return new Employee(
						rs.getString("pass"),
						rs.getString("username"),
						rs.getString("last_name"),
						rs.getString("first_name"),
						rs.getInt("employee_id"));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Employee createEmployee(Employee e)
	{
		String sql = "insert into employee (default, ?, ?, ?, ?) returning *";
		
		
		try (Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, e.getFirstName());
			ps.setString(2, e.getLastName());
			ps.setString(3, e.getUsername());
			ps.setString(4, e.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return new Employee(
						rs.getString("pass"),
						rs.getString("username"),
						rs.getString("last_name"),
						rs.getString("first_name"),
						rs.getInt("employee_id"));
			}
		} catch (SQLException f)
		{
			f.printStackTrace();
		}
		
		return null;
	}

	public Employee getEmployeeByUserName(String username) 
	{
		String sql = "select * from employee where username = ?";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return new Employee(
						rs.getString("pass"),
						rs.getString("username"),
						rs.getString("last_name"),
						rs.getString("first_name"),
						rs.getInt("id"));
					
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

}
