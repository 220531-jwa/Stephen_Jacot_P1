package dev.jacot.services;

import dev.jacot.models.FinanceManager;
import dev.jacot.repo.FinanceManagerDAO;

public class FinanceManagerService 
{
	
	
//	private FinanceManagerDAO fd = new FinanceManagerDAO();
	public FinanceManagerDAO fd;
	
	public FinanceManagerService(FinanceManagerDAO fd)
	{
		this.fd = fd;
	}
	
	public FinanceManager login(String username, String password) 
	{
		FinanceManager fm = fd.getFinanceManagerByUserName(username);
		
		System.out.println(fm);
		
		if(fm.getManagePassword().equals(password))
		{
			return fm;
		}
		
		return null;
	}

}
