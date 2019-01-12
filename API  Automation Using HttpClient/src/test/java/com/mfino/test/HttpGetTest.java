package com.mfino.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mfino.base.TestBase;
import com.mfino.restclient.RestClient;
import com.mfino.util.TestUtil;

public class HttpGetTest extends TestBase{

	public HttpGetTest() throws IOException {
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
	public void getTest() throws ClientProtocolException, IOException
	{
		RestClient restclientget= new RestClient();
		httpresponse=restclientget.getRestClient(completeurl);
		//Status
		int statusCode=httpresponse.getStatusLine().getStatusCode();
		System.out.println("Status code of "  +completeurl+ "is  " +statusCode);
		
		Assert.assertEquals(statusCode, 200);
		//Response in string
		String stringresponse= EntityUtils.toString(httpresponse.getEntity(),"UTF-8");
		System.out.println("Response of a get Request is " +stringresponse);//It returns String Object
		
		//Response in JSON
		JSONObject jsonresponse= new JSONObject(stringresponse); // Converting string to JSON
		System.out.println("Response in JSON Format is " +jsonresponse);
		
		
		TestUtil test= new TestUtil();
		
		//printing value for per_page key --Normal JSON
		String PerPage= test.testutil(jsonresponse, "/per_page");
		
		System.out.println("Per Page count is " +PerPage);
		
		//JSONDATA--> "/data[0]/id" means data is a sub json in json(JSONArray) id is a key in data array, printing 0 index value
		String data= test.testutil(jsonresponse, "/data[0]/id");
	
		System.out.println("ID in data array is "+data);
		
		Header headerarray[]= httpresponse.getAllHeaders();
		
		HashMap<String, String> hm= new HashMap<String, String>();
		
		for(Header header :headerarray )
		{
			hm.put(header.getName(), header.getValue());
		}
	
		System.out.println(hm);
		
		
	}
}
