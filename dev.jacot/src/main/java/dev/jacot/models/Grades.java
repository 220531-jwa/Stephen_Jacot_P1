package dev.jacot.models;

public class Grades 
{
	private int gradeId;
	private char letterGrade;
	private boolean presentation;
	private boolean passOrFail;
	
	public Grades() 
	{
		
	}

	public Grades(int gradeId, char letterGrade, boolean presentation, boolean passOrFail) 
	{
		this.gradeId = gradeId;
		this.letterGrade = letterGrade;
		this.presentation = presentation;
		this.passOrFail = passOrFail;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public char getLetterGrade() {
		return letterGrade;
	}

	public void setLetterGrade(char letterGrade) {
		this.letterGrade = letterGrade;
	}

	public boolean isPresentation() {
		return presentation;
	}

	public void setPresentation(boolean presentation) {
		this.presentation = presentation;
	}

	public boolean isPassOrFail() {
		return passOrFail;
	}

	public void setPassOrFail(boolean passOrFail) {
		this.passOrFail = passOrFail;
	}
}
