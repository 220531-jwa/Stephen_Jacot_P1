package dev.jacot.models;

public class Employee 
{
	private String password;
	
	private String username;
	
	private String lastName;
	
	private String firstName;
	
	private int id;
	
	public Employee()
	{
		
	}
	
	public Employee(String password, String username, String lastName, String firstName, int id)
	{
		this.password = password;
		this.username = username;
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [password=" + password + ", username=" + username + ", lastName=" + lastName + ", firstName="
				+ firstName + ", id=" + id + "]";
	}
	
	
	

	
	

}
