package dev.jacot.models;

public class FinanceManager 
{
	private String manageUsername;
	private String managePassword;
	private String manageFirstName;
	private String manageLastName;
	private int manageId;
	
	public FinanceManager()
	{
		
	}
	
	public FinanceManager(String manageUsername, String managePassword, String manageFirstName, String manageLastName, int manageId)
	{
		this.manageUsername = manageUsername;
		this.managePassword = managePassword;
		this.manageFirstName = manageFirstName;
		this.manageLastName = manageLastName;
		this.manageId = manageId;
	}
	
	public String getManageUsername()
	{
		return manageUsername;
	}
	
	public void setManageUsername(String manageUsername)
	{
		this.manageUsername = manageUsername;
	}

	public String getManagePassword() {
		return managePassword;
	}

	public void setManagePassword(String managePassword) {
		this.managePassword = managePassword;
	}

	public String getManageFirstName() {
		return manageFirstName;
	}

	public void setManageFirstName(String manageFirstName) {
		this.manageFirstName = manageFirstName;
	}

	public String getManageLastName() {
		return manageLastName;
	}

	public void setManageLastName(String manageLastName) {
		this.manageLastName = manageLastName;
	}

	public int getManageId() {
		return manageId;
	}

	public void setManageId(int manageId) {
		this.manageId = manageId;
	}

	@Override
	public String toString() {
		return "FinanceManager [manageUsername=" + manageUsername + ", managePassword=" + managePassword
				+ ", manageFirstName=" + manageFirstName + ", manageLastName=" + manageLastName + ", manageId="
				+ manageId + "]";
	}
	
	

}
