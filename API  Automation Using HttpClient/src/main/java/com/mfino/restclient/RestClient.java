package com.mfino.restclient;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;



public class RestClient {

	
	//Get Request
	public CloseableHttpResponse getRestClient(String url) throws ClientProtocolException, IOException
	{
		//CloseableHttpClient(Abstract class of HttpClients(I)
		//HttpClients(I) -- creates a default connection over the network
		CloseableHttpClient httprequest=  HttpClients.createDefault();//It creates a default http client request(makes a default connection over the network
		HttpGet httpget= new HttpGet(url);//--> http get which is used to retrieve data.
		CloseableHttpResponse httpresponse= httprequest.execute(httpget); // Hits the Url
		
		//response gets stored in httpresponse object of CloseableHttpResponse(I)
		return httpresponse;		
	}
	//POST Request
	public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headermap) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpclient= HttpClients.createDefault();
		HttpPost httppost= new HttpPost(url);//Which is used to post data in request
		httppost.setEntity(new StringEntity(entityString));//entityString is an object string which is used to pass in a request
		//headermap is an entity which is used to set header of a request
		for(Map.Entry<String,String> entry : headermap.entrySet()){
			httppost.addHeader(entry.getKey(), entry.getValue());
		}
		
		CloseableHttpResponse httpresponse= httpclient.execute(httppost);
		return httpresponse;
	}
	
}
