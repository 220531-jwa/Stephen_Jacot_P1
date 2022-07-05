package dev.jacot.controller;

import dev.jacot.models.FinanceManager;
import dev.jacot.services.FinanceManagerService;
import io.javalin.http.Context;

public class FinanceManagerController 
{
	
	private FinanceManagerService fs;
	
	public FinanceManagerController(FinanceManagerService fs)
	{
		this.fs = fs;
	}
	
	public void loginManager(Context ctx)
	{
		FinanceManager fm = ctx.bodyAsClass(FinanceManager.class);
		
		FinanceManager loggedFinanceManager = fs.login(fm.getManageUsername(), fm.getManagePassword());
		
		System.out.println(loggedFinanceManager);
		
		if(loggedFinanceManager != null)
		{
			ctx.json(loggedFinanceManager);
			ctx.sessionAttribute("Logged in manager", loggedFinanceManager);
		}
		
	}

}
