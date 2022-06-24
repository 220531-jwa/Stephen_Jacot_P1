package dev.jacot;

import dev.jacot.controller.EmployeeController;
import dev.jacot.repo.EmployeeDAO;
import dev.jacot.services.EmployeeService;
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

		Javalin app = Javalin.create(config -> {
			config.addStaticFiles("/public", Location.CLASSPATH);
		});
		
		app.start();
		
		app.routes(() -> {
//			path("/register", () -> {
//				post(ec::createNewEmployee);
			path("/login", () -> {
				
			});
			
			});
	}

}
