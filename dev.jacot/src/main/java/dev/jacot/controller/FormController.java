package dev.jacot.controller;

import java.util.List;

import dev.jacot.models.Employee;
import dev.jacot.models.Form;
import dev.jacot.services.FormService;
import io.javalin.http.Context;

public class FormController 
{
	private static FormService fs;
	private static Employee ey;
	
	public FormController(FormService fs)
	{
		this.fs = fs;
	}
	
	
	public void createForm(Context ctx) 
	{
		Form f = ctx.bodyAsClass(Form.class);
		
		int formId = f.getFormId();
		
		String formDate = f.getFormDate();
		
		String formTime = f.getFormTime();
		
		int eventType = f.getEventType();
		
		int eventCost = f.getEventCost();
		
		int formStatus = f.getFormStatus();
		
		String eFirstName = f.geteFirstName();
		
		String eLastName = f.geteLastName();
		
		String formJustification = f.getFormJustification();
		
		int gradeType = f.getGradeType();
		
		String eventLocation = f.getEventLocation();
		
		String eventDescription = f.getEventDescription();
		
		int employeeId = f.getEmployeeId();
		
		Form form = null;
		
		try 
		{
			form = fs.createRequest(f);
		
			if(form != null)
			{
				if(f.getEventCost() < 1000)
				{
					ctx.status(200);
					ctx.json(form);
				}
				else
				{
					ctx.status(404);
				}
			} else
			{
				ctx.status(404);
			}
			
			
			if(((Employee) ctx.sessionAttribute("logged in employee")).getId() != f.getEmployeeId())
			{
				ctx.status(404);
			}
			else
			{
				ctx.status(200);
				ctx.json(form);
			}
			
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void getAllForms(Context ctx)
	{
		List<Form> f = fs.getAllForms();
		
		if(f != null)
		{
			ctx.status(200);
			
			ctx.json(f);
		} else {
			ctx.status(404);
		}
	}
	
	public void getFormByEmployeeId(Context ctx)
	{
		Employee em = ctx.bodyAsClass(Employee.class);
		
		List<Form> f = null;
		
		int employeeId = em.getId();
				
		
		try {
			
			f = fs.getFormsById(employeeId);
			
			ctx.status(200);
			
			ctx.json(f);
		} catch (Exception e) {
			ctx.status(404);
		}
//		if(f != null)
//		{
//			ctx.status(200);
//			ctx.json(f);
//		} else {
//			ctx.status(404);
//		}
	}
	
	public void denyForm(Context ctx)
	{
		Form f = ctx.bodyAsClass(Form.class);
		
		boolean success = fs.denyForm(f);
		
		try {
			
			if(!success)
			{
				ctx.status(404);
			}
			else
			{
				ctx.status(200);
				ctx.json(f);
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public void approveForm(Context ctx)
	{
		Form f = ctx.bodyAsClass(Form.class);
		
		boolean success = fs.approveForm(f);
		
		try {
			
			if(!success)
			{
				ctx.status(404);
			}
			else
			{
				ctx.status(200);
				ctx.json(f);
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public void editForm(Context ctx)
	{
		Form f = ctx.bodyAsClass(Form.class);
		
		boolean success = fs.editForm(f);
		
		try {
			
			if(!success)
			{
				ctx.status(404);
			} else {
				ctx.status(200);
				ctx.json(f);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
