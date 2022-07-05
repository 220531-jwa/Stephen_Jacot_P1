package dev.jacot.services;

import dev.jacot.models.Form;
import dev.jacot.repo.EmployeeDAO;
import dev.jacot.repo.FormDAO;

import java.sql.ResultSet;
import java.util.List;

public class FormService 
{
	
	private static FormDAO fd;
	
	public EmployeeDAO ed = new EmployeeDAO();
	
	public FormService(FormDAO fd)
	{
		this.fd = fd;
	}
	
	public Form createRequest(Form f)
	{
		
		if(f.getEventCost() < 1000 && f.getFormStatus() == 0)
		{
			f.setTotal(f.getEventCost());
			
			System.out.println(f.getTotal());
			
			return fd.createForm(f);
		}
		else
		{
			return null;
		}
		
	}

	public List<Form> getAllForms() 
	{
		// TODO Auto-generated method stub
		return fd.getAllForms();
	}
	
	public int getSumOfRequests()
	{
		return fd.getSumOfRequests();
	}
	
	public List<Form> getFormsById(int employeeId)
	{
		return fd.getFormById(employeeId);
	}
	
	public boolean denyForm(Form f)
	{
		if(f != null)
		{
			f.setFormStatus(2);
			
			return fd.denyForm(f);
		}
		
		return true;
	}

	public boolean approveForm(Form f) 
	{
		// TODO Auto-generated method stub
		
		if(f != null)
		{
			f.setFormStatus(1);
			
			return fd.approveForm(f);
		}
		
		return false;
	}
	
	public boolean editForm(Form f)
	{
		if(f != null)
		{
			return fd.editForm(f);
		}
		
		return true;
	}

}
