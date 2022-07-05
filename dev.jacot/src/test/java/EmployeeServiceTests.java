import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.jacot.models.Employee;
import dev.jacot.repo.EmployeeDAO;
import dev.jacot.services.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests 
{
	@InjectMocks
	private static EmployeeService mockEs;
	
	@Mock
	private static EmployeeDAO mockEd;
	
	@BeforeEach
	public void setupEach()
	{
		mockEs = new EmployeeService(mockEd);
	}
	
	@Test
	public void loginUser() {
		
		//Given
		Employee mock = new Employee("nicehat", "jame", "James", "Carrol",1);
		//When
		when(mockEd.getEmployeeByUserName("jame")).thenReturn(mock);
		//Then
		assertEquals(mock, mockEs.login("jame", "nicehat"));
		
	}
	
	@Test
	public void invalidLogin() {
		//Given
		Employee mock = new Employee("darklord", "darth", "Anakin", "Skywalker", 2);
		//When
		when(mockEd.getEmployeeByUserName("wockyhard")).thenReturn(mock);
		//Then
		assertNotEquals(mock, mockEs.login("wockyhard", "no"));
	}
	
	@Test
	public void loginWithBadPass() {
		//given
		Employee mock = new Employee("thepass", "theuser", "Jame", "Here", 1);
		
		//when
		when(mockEd.getEmployeeByUserName("theuser")).thenReturn(mock);
		
		//then
		assertNotEquals(mock, mockEs.login("theuser", "bad"));
	}

}
