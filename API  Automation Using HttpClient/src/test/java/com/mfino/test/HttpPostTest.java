package com.mfino.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mfino.base.TestBase;
import com.mfino.data.Users;
import com.mfino.restclient.RestClient;

public class HttpPostTest extends TestBase{

	public HttpPostTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	TestBase testbase;
	String Url;
	String serviceurl;
	String completeurl;
	CloseableHttpResponse httpresponse;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		testbase = new TestBase();
		Url=prop.getProperty("url");
		serviceurl= prop.getProperty("serviceurl");
		
		completeurl= Url + serviceurl;
		
	}
	@Test
	public void postApi() throws JsonGenerationException, JsonMappingException, IOException
	{
		RestClient restClient= new RestClient();
		
		//Used to set header entity in the form of json
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		
		//Jackson API
		
		//ObjectMapper is a class which is used to get object details into JSON and JSON to JAVA object, mainly used for a technique marshelling and unmarshelling
		ObjectMapper obj = new ObjectMapper();
		//Addind values to a variable for an object class
		Users users= new Users("NARAYANA", "QA Managing Director");
		//Path of a JSON file
		obj.writeValue(new File("D:/API  Automation/RestClient/src/main/java/com/mfino/data/user.json"), users);
		
	/*	//obj to JSON
		String responseinstring=obj.writeValueAsString(users);
		System.out.println(responseinstring);
		*/
		
		
	}

}
