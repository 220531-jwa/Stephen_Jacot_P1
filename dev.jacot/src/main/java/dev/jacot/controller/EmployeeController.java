package dev.jacot.controller;

import java.util.List;

import dev.jacot.models.Employee;
import dev.jacot.services.EmployeeService;
import io.javalin.http.Context;

public class EmployeeController 
{
	private static EmployeeService es;
	
	
	public EmployeeController(EmployeeService es)
	{
		this.es = es;
	}
	public void loginEmployee(Context ctx) 
	{
		Employee e = ctx.bodyAsClass(Employee.class);
		
		Employee loggedInEmployee = es.login(e.getUsername(), e.getPassword());
		ctx.json(loggedInEmployee);
	}
	
	public static void getAllEmployees(Context ctx)
	{
		ctx.status(200);
		
		List<Employee> employee = es.getAllClients();
	}
	
	public void createNewEmployee(Context ctx)
	{
		ctx.status(201);
		
		Employee employeeFromRequestBody = ctx.bodyAsClass(Employee.class);
		Employee e = es.createEmployee(employeeFromRequestBody);
		ctx.json(e);
	}
	
	

}
