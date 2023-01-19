package com.nitara.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.json.JSONObject;
import org.junit.Rule;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.nitara.Reports.Report;
import com.nitara.utilities.ExcelUtils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GenericBase {

	//public String token;

	public static Properties prop;


	public GenericBase()
	{
		try 
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream("src/main/java/com/nitara/config/Config.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}


//	@BeforeMethod(alwaysRun = true)
//	public void getUserAuthenticationToken() {
//
//		RestAssured.baseURI = prop.getProperty("baseurl");
//		String abstractname = "/v3/AM/UserLogin";
//
//	
//		RequestSpecification request = RestAssured.given();
//		JSONObject requestParams = new JSONObject();
//		requestParams.put("countryCode", "+91"); // Cast
//		requestParams.put("Phone", "7760677616"); // Cast	
//		requestParams.put("Pin", "123456");
//		requestParams.put("deviceName", "OnePlus"); 		 
//		requestParams.put("deviceType",  "Mobile");
//		requestParams.put("key",  "com.nitara.farmer");
//		//requestParams.put("key",  "com.nitara.trading");
//		
//		Response response = request.body(requestParams.toString())
//				.header("Content-Type", "application/json")
//				.post(abstractname);
//
//		//Print response
//		response.prettyPeek();
//
//		//Validate status code
//		Assert.assertEquals(response.getStatusCode(),200);
//
//
//		String jsonString = response.asString();
//		String  message = JsonPath.from(jsonString).get("message");
//
//		token = JsonPath.from(jsonString).get("token");
//		
////		
////		RestAssured.baseURI = "http://test.nitara.co.in";
////		String filepath = prop.getProperty("AccountManagement");
////		String abstractname = prop.getProperty("UserLoginV2");
////
////		RequestSpecification request = RestAssured.given();
////		JSONObject requestParams = new JSONObject();
////		requestParams.put("countryCode", "+91"); // Cast
////		requestParams.put("Phone", "7760677616"); // Cast	
////		requestParams.put("Password", "123456");
////		requestParams.put("deviceName", "DELL_PC"); 		 
////		requestParams.put("deviceType",  "LAPTOP");
////		requestParams.put("key",  "com.nitara.farmer");
////		
////		Response response = request.body(requestParams.toString())
////				.header("Content-Type", "application/json")
////				.post(abstractname);
////
////		//Print response
////		response.prettyPeek();
////
////		//Validate status code
////		Assert.assertEquals(response.getStatusCode(),200);
////
////
////		String jsonString = response.asString();
////		String  message = JsonPath.from(jsonString).get("message");
////		//Validate success message
////		Assert.assertEquals(message,"Logged in successfully.");
////		
////		token = JsonPath.from(jsonString).get("token");
//
//	}

}
