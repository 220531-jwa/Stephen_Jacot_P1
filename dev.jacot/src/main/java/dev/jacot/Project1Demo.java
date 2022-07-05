package dev.jacot;

import dev.jacot.controller.EmployeeController;
import dev.jacot.controller.FinanceManagerController;
import dev.jacot.controller.FormController;
import dev.jacot.controller.GradesController;
import dev.jacot.models.Employee;
import dev.jacot.repo.EmployeeDAO;
import dev.jacot.repo.FinanceManagerDAO;
import dev.jacot.repo.FormDAO;
import dev.jacot.repo.GradesDAO;
import dev.jacot.services.EmployeeService;
import dev.jacot.services.FinanceManagerService;
import dev.jacot.services.FormService;
import dev.jacot.services.GradesService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.patch;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

public class Project1Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDAO ed = new EmployeeDAO();
		
		EmployeeController ec = new EmployeeController(new EmployeeService(new EmployeeDAO()));
		
		FinanceManagerController fc = new FinanceManagerController(new FinanceManagerService(new FinanceManagerDAO()));
		
		FormController fmc = new FormController(new FormService(new FormDAO()));
		
		GradesController gc = new GradesController(new GradesService(new GradesDAO()));

		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
			config.addStaticFiles("/public", Location.CLASSPATH);
		});
		
		app.start(8010);
		
		app.routes(() -> {
//			path("/register", () -> {
//				post(ec::createNewEmployee);
			path("/employeelogin", () -> 
			{
				post(ec::loginEmployee);
				
				path("/submit", () ->
				{
					post(fmc::createForm);
				});
				
				path("/gradesubmit", () ->
				{
					post(gc::createGrade);
				});
				
				path("/viewforms", () ->
				{
					get(fmc::getAllForms);
				});
				
				path("/editform", () -> 
				{
					put(fmc::editForm);
				});
				
			});
			
			path("/managerlogin",() -> {
				post(fc::loginManager);
				
				path("/fmrequestform", () -> 
				{
					get(fmc::getAllForms);
				});
				
				path("/formdeny", () ->
				{
					put(fmc::denyForm);
				});
				
				path("/formapprove", () ->
				{
					put(fmc::approveForm);
				});
				
				path("/viewgrades", () -> 
				{
					get(gc::getAllGrades);
				});
				
			});
			
			
			path("/getSession", () -> {
				get(ctx -> {
					// once set, we can access that session attribute
					Employee loggedInUser = ctx.sessionAttribute("loggedInUser");
					System.out.println(loggedInUser);
				});
			});
			
			});
	}

}
