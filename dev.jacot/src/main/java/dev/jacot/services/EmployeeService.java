package dev.jacot.services;

import java.util.List;

import dev.jacot.models.Employee;
import dev.jacot.repo.EmployeeDAO;

public class EmployeeService 
{

	private EmployeeDAO ed = new EmployeeDAO();
	
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
		Employee e = EmployeeDAO.getEmployeeByUserName(username);
		
		if(e.getPassword().equals(password))
		{
			return e;
		}
		
		return null;
	}

}
