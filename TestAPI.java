package com.bridgelabz_Testing_API;
import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestAPI {
	String uri = "http://localhost:3000";   //Instance Variable(As global)
	
	/**
	 * Method: This method is used to creating or add another user details 
	 */
	@Test
	public void CreateDetails(){
		System.out.println("________________________________________________________________");
		System.out.println("\n*****For Post Request******");
		
		//Specifying the the URl
		RestAssured.baseURI = uri;
		
		//Getting requestSpecification of request
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.header("Content-Type","application/json");   //for post Method we need to mention in the body only 
		httpRequest.body("{\r\n"
				+ "        \"id\": 5,\r\n"
				+ "        \"title\": \"Java\",\r\n"
				+ "        \"author\": \"RajKawale\"\r\n"
				+ "    }");
			
		//Passing the request "Post"
		Response response = httpRequest.request(Method.POST, "/posts");  
				
		//Printing the Status and response of server
		System.out.println("The result of status code is: " + response.getStatusCode());
		System.out.println("The response Time has taken: " + response.getTime());
		System.out.println("The Result of Creating response is: " + response.asPrettyString());
		System.out.println("________________________________________________________________");
	}
}