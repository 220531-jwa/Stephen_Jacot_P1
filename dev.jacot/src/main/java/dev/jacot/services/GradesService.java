package dev.jacot.services;

import java.util.List;

import dev.jacot.models.Grades;
import dev.jacot.repo.FormDAO;
import dev.jacot.repo.GradesDAO;

public class GradesService 
{
	
	private static GradesDAO gd;
	
	public GradesService(GradesDAO gd)
	{
		this.gd = gd;
	}

	public Grades createGrades(Grades g) 
	{
		if(g.getLetterGrade() == 0)
		{
			g.setLetterGrade(' ');
		}
		
		return gd.createGrades(g);
	}

	public List<Grades> getAllGrades() 
	{
		return gd.getAllGrades();
	}

}
