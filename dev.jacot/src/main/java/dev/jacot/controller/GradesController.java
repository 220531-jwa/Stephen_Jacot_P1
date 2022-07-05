package dev.jacot.controller;

import java.util.List;

import dev.jacot.models.Grades;
import dev.jacot.services.GradesService;
import io.javalin.http.Context;

public class GradesController 
{
	private static GradesService gs;
	
	public GradesController(GradesService gs)
	{
		this.gs = gs;
	}
	
	public void createGrade(Context ctx)
	{
		
		Grades g = ctx.bodyAsClass(Grades.class);
		
		int gradeId = g.getGradeId();
		
		char letterGrade = g.getLetterGrade();
		
		boolean presentation = g.isPresentation();
		
		boolean passOrFail = g.isPassOrFail();
		
		Grades grade = null;
		
		try {
			
			grade = gs.createGrades(g);
			
			if(grade != null)
			{
				ctx.status(200);
				
				ctx.json(grade);
			} else {
				ctx.status(404);
			}
			
			
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void getAllGrades(Context ctx)
	{
		List<Grades> g = gs.getAllGrades();
		
		if(g != null)
		{
			ctx.status(200);
			
			ctx.json(g);
		} else {
			ctx.status(404);
		}
	}

}
