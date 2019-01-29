package com.mfino.util;

import org.testng.annotations.Test;
import org.json.JSONArray;
import org.json.JSONObject;

public class TestUtil {

	//JSONObject -- Contains json response
	// jpath contains key
	@Test
	public String  testutil(JSONObject responsejson, String jpath)
	{
		Object obj=responsejson;//response gets stored in obj object
		for(String s: jpath.split("/"))//Storing jpath value in s
		{
			if(!s.isEmpty())
			{
				if(!(s.contains("[") || s.contains("]")))//Direct key and values
				{
					obj = ((JSONObject) obj).get(s);
				}
				else if(s.contains("[") || s.contains("]"))//dataArray
				{
					obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
				}
			}
		}
		return obj.toString();

	}
	
	
}
