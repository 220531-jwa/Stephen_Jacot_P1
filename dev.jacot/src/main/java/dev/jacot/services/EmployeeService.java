package dev.jacot.services;

import java.util.List;

import dev.jacot.models.Employee;
import dev.jacot.repo.EmployeeDAO;

public class EmployeeService 
{

		private static EmployeeDAO ed;
		public EmployeeService(EmployeeDAO ed)
		{
			this.ed = ed;
		}
	
	
	public List<Employee> getAllClients() 
	{
	
		return null;
	}


	public Employee createEmployee(Employee e) 
	{
		return ed.createEmployee(e);
	}


	public Employee login(String username, String password) 
	{
		Employee e = ed.getEmployeeByUserName(username);
		if(e.getUsername().equals(username))
		{
			if(e.getPassword().equals(password))
			{
				return e;
			} else {
				System.out.println("Invalid credentials");
				return null;
			}
		} else {
			System.out.println("Invalid Username");
			return null;
		}
	}
	
	

}
