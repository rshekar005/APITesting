package com.raja.test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import groovyjarjarasm.asm.commons.Method;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	
	@Test
	public void getRequest() throws IOException 
	{

	/*Rest Assured is a class
	 * It creates HTTP Requests against a base URI
It supports creating Request of different HTTP method types (GET, POST, PUT, PATH, DELETE, UPDATE, HEAD 
and OPTIONS)
It makes HTTP communication with the server and passes on the Request that we created in our tests to the server.
Retrieves the Response from the server.
Helps validate the Response received from the server. 	
	 */	
		RestAssured.baseURI="https://reqres.in/api/users";
		//RequestSpecification is an interface which allows us to modify headers and authentication
		RequestSpecification httprequest= RestAssured.given();
		//Response is an interface
		//Make a request to the server by specifying the method Type and the method URL.
		 // This will return the Response from the server. Store the response in a variable.
		//Make a request type as Get directly by appending get method to RequestSpecification
		Response response= httprequest.get("/2");
		
	
		//Response in JSON
	//	JSONObject jsonresponse= new JSONObject(); // Converting string to JSON
		System.out.println("Response in JSON Format is " +response.asString());

		System.out.println("*********************************************");
		int statusCode= response.getStatusCode();
		        System.out.println("Status code of a reponse is" +statusCode);	
		Assert.assertEquals(statusCode, 200);
		
		System.out.println("*********************************************");
		
		String ContentType= response.header("Content-type");
				System.out.println("content type is "+ContentType);
				Assert.assertEquals(ContentType, "application/json; charset=utf-8");
				System.out.println("*********************************************");
		String server= response.header("Server");
				System.out.println("server is "+server);
				System.out.println("*********************************************");
		Headers allHeaders= response.headers();
		
		for(Header header: allHeaders)
		{
			System.out.println("Key is "+header.getName() +"and"+ "Value is" +header.getValue());
		}
		
		System.out.println("*********************************************");
		
		ResponseBody body = response.body();
		
		String bodyasString = body.asString();
		
		System.out.println(bodyasString);
		FileWriter file= new FileWriter("D:/Automation/APITestingUsingRestAssured/src/test/java/com/raja/test/ouput/output");
		file.write(bodyasString);
			
		//Response response1= httprequest.get("/last.json").then().assertThat().body("MRData.total", equals(1));
	System.out.println();
		JsonPath jsonEvaluator= response.jsonPath();
		String circuitName= jsonEvaluator.get("Janet");
		System.out.println(circuitName);
		//Assert.assertEquals(circuitName, "Shanghai International Circuit");
	}
}
