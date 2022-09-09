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
	
	/**
	 * Method: This method is used to fetch certain user's details
	 */
	@Test
	public void getMethod() {
		System.out.println("\n****For Get Request****");
		
		RequestSpecification httpRequest1 = RestAssured.given().baseUri(uri);
		Response response = httpRequest1.request(Method.GET, "/posts/");
		
		//Printing the Status and response of server
		response.asPrettyString();
		System.out.println("The result of status code is : " + response.getStatusCode());
		System.out.println("The response Time has taken : " + response.getTime());
		System.out.println("The result of getting user's details: " + response.asPrettyString());
		System.out.println("________________________________________________________________");
	}
	
	/**
	 * Method: This method is used to Update Certain user's details
	 */
	@Test
	public void putMethod() {
		System.out.println("\n****For Put Request****");
		
		RequestSpecification httpRequest2 = RestAssured.given().baseUri(uri);
		httpRequest2.header("Content-Type","application/json");   //for Put Method: We need to specify changes in the body 
		httpRequest2.body("{\r\n"
				+ "        \"id\": 2,\r\n"
				+ "        \"title\": \"Rest API-Assured Java library_Raj\"\r\n"
				+ "    }");
		
		//Passing the request "Put"
		Response response = httpRequest2.request(Method.PUT, "/posts/2");     //Passing id of user
		
		//Printing the Status and response of server
		System.out.println("The result of status code is : " + response.getStatusCode());
		System.out.println("The response Time has taken : " + response.getTime());
		System.out.println("The result of updating user's details: " + response.asPrettyString());
		System.out.println("________________________________________________________________");
	}
	
	/**
	 * Method: This method is used to do partially Update in Certain user's details
	 */
	
	@Test
	public void patchMethod() {
		System.out.println("\n****For Patch Request****");
		
		RequestSpecification httpRequest3 = RestAssured.given().baseUri(uri);
		//for Patch Method: We need to specify changes in the body
		httpRequest3.header("Content-Type","application/json");
		httpRequest3.body("{\r\n"
				+ "        \"author\": \"Raj_kawale\"\r\n"
				+ "    }");
		
		//Passing the request "Patch"
		Response response = httpRequest3.request(Method.PATCH, "/posts/1");     //Passing id of user
		
		//Printing the Status and response of server
		System.out.println("The result of status code is : " + response.getStatusCode());
		System.out.println("The response Time has taken : " + response.getTime());
		System.out.println("The result of updating user's Partial details: " + response.asPrettyString());
		System.out.println("________________________________________________________________");
	}
	
	/**
	 * Method: This method is used to Delet the User entry
	 */
	@Test
	public void deletMethod() {
		System.out.println("\n****For Delet Request****");
		
		RequestSpecification httpRequest4 = RestAssured.given().baseUri(uri);
		
		//Passing the request "Patch"
		httpRequest4.header("Content-Type","application/json");
		httpRequest4.body("{\r\n"
				+ "        \"id\": 5,\r\n"
				+ "        \"title\": \"Java\",\r\n"
				+ "        \"author\": \"RajKawale\"\r\n"
				+ "    }");

		Response response = httpRequest4.request(Method.DELETE, "/posts/5");   //Passing id of user
	
		//Printing the Status and response of server
		System.out.println("The result of status code is : " + response.getStatusCode());
		System.out.println("The response Time has taken : " + response.getTime());
		System.out.println("The result of Deleting user's entry: " + response.asPrettyString() + "-Blank-");
		System.out.println("________________________________________________________________");
	}
}