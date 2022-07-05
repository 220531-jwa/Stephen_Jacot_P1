import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.jacot.models.Form;
import dev.jacot.repo.FormDAO;
import dev.jacot.services.FormService;

@ExtendWith(MockitoExtension.class)
public class FormServiceTests {
	
	@InjectMocks
	private static FormService mockFs;
	
	@Mock
	private static FormDAO mockFd;
	
	@BeforeEach
	public void setupEach()
	{
		mockFs = new FormService(mockFd);
	}
	
	@Test
	public void createValidForm()
	{
		//Given
		Form mock = new Form(1, "2/20/22", "2:00PM", "Needed programming Courses", 
				"Jackson", "Star", "Texas Road", 100, 1000, 1, "Needed to learn c++", 1, 2,
				1);
		
		Form mockTest = new Form(1, "2/20/22", "2:00PM", "Needed programming Courses", 
				"Jackso", "Star", "Texas Road", 100, 1000, 1, "Needed to learn c++", 1, 2,
				1);
		//When
		when(mockFd.createForm(mock)).thenReturn(mockTest);
		
		//Then
		try {
			assertEquals(mockTest, mockFs.createRequest(mock));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void getAllValidRequests()
	{
		//Given
		List<Form> mock = new ArrayList<>();
		
		mock.add(new Form(1, "2/20/22", "2:00PM", "Needed programming Courses", 
				"Jackso", "Star", "Texas Road", 100, 1000, 1, "Needed to learn c++", 1, 2,
				1));
		mock.add(new Form(2, "5/20/22", "3:00PM", "Needed business courses", 
				"Jack", "Noel", "T", 100, 10, 2, "Needed to learn business technique", 3, 1,
				2));
		
		//When
		when(mockFd.getAllForms()).thenReturn(mock);
		
		//Then
		assertEquals(mock, mockFs.getAllForms());
	}
	
	@Test
	public void validDenyForm()
	{
		//Given
		Form mock = new Form(1, "2/20/22", "2:00PM", "Needed programming Courses", 
				"Jackson", "Star", "Texas Road", 100, 1000, 1, "Needed to learn c++", 1, 2,
				1);
		//When
		when(mockFd.denyForm(mock)).thenReturn(true);
		//Then
		assertEquals(mock, mockFs.denyForm(mock));
	}

}
