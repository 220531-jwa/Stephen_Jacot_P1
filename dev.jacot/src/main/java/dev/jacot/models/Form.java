package dev.jacot.models;

public class Form 
{
	private int formId;
	private String formDate;
	private String formTime;
	private String eFirstName;
	private String eLastName;
	private String eventDescription;
	private String eventLocation;
	private int eventCost;
	private int total;
	private int formStatus;
	private String formJustification;
	private int eventType;
	private int gradeType;
	private int employeeId;
	
	public Form()
	{
		
	}

	

	public Form(int formId, String formDate, String formTime,String eventDescription, 
			String eFirstName, String eLastName, String eventLocation, 
			int eventCost, int total, int formStatus,String formJustification,int eventType,int gradeType, 
			int employeeId) 
	{
		this.formId = formId;
		this.formDate = formDate;
		this.formTime = formTime;
		this.eventDescription = eventDescription;
		this.eFirstName = eFirstName;
		this.eLastName = eLastName;
		this.eventLocation = eventLocation;
		this.eventCost = eventCost;
		this.total = total;
		this.formStatus = formStatus;
		this.formJustification = formJustification;
		this.eventType = eventType;
		this.gradeType = gradeType;
		this.employeeId = employeeId;
	}



	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public String getFormDate() {
		return formDate;
	}



	public void setFormDate(String formDate) {
		this.formDate = formDate;
	}

	public String getFormTime() {
		return formTime;
	}


	public void setFormTime(String formTime) {
		this.formTime = formTime;
	}


	public String getEventDescription() {
		return eventDescription;
	}




	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}




	public String getEventLocation() {
		return eventLocation;
	}




	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}




	public int getEventCost() {
		return eventCost;
	}




	public void setEventCost(int eventCost) {
		this.eventCost = eventCost;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getFormJustification() {
		return formJustification;
	}

	public void setFormJustification(String formJustification) {
		this.formJustification = formJustification;
	}

	public int getEventType() {
		return eventType;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	public int getGradeType() {
		return gradeType;
	}

	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String geteFirstName() {
		return eFirstName;
	}

	public void seteFirstName(String eFirstName) {
		this.eFirstName = eFirstName;
	}
	
	public int getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(int formStatus) {
		this.formStatus = formStatus;
	}

	public String geteLastName() {
		return eLastName;
	}

	public void seteLastName(String eLastName) {
		this.eLastName = eLastName;
	}
	
	

	
	
	
	
	
	
	

}
