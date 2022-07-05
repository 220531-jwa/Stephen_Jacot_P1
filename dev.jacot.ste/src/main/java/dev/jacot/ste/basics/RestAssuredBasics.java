package dev.jacot.ste.basics;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;


public class RestAssuredBasics 
{
	// RestAssured works on three principles : Given When Then
	
	
	public static void main(String[] args)
	{
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		
		
		// Given - all of the input details
		 given().
			header("Content-Type", "application/json").
		
		
		
		// When - the API is 'hit' -> Receives a request
		when().log().all().get("todos/1")
		
		// Then - the response is validated
		
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.header("Server", "cloudflare")
		.body("id", equalTo(1))
		.body("title", equalTo("delectus aut autem"));
	}
	
	

}
