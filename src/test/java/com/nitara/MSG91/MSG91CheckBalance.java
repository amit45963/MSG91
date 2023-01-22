package com.nitara.MSG91;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nitara.base.GenericBase;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.XmlPath.CompatibilityMode;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class MSG91CheckBalance extends GenericBase{
	
	@Test(groups= {"Smoke"})
    @Parameters({ "url" })
	public void msg91CheckBalance(String url) throws Exception{
		
		//String url  = prop.getProperty("MSG91CheckBalance");
		String abstractname = prop.getProperty("EndpointMsg91");
		RestAssured.baseURI = url;

		RequestSpecification request = RestAssured.given().queryParam("authkey","342142AI8CiNCWgF55f65ccddP1")
	              .queryParam("type", "0");
		Response response = request.get(abstractname);
		
		
		//Print response
		//response.prettyPeek();

		//Validate status code
		Assert.assertEquals(response.getStatusCode(),200);
		String jsonString = response.asString();
		
		
		XmlPath doc = new XmlPath(
                CompatibilityMode.HTML,
                jsonString);
		String title = doc.getString("html.body");
		System.out.println(title);
		
		double balance = Double.parseDouble(title);
		
		System.out.println("Hi Team");
		System.out.println("Hi All," + '\n' );
		
		if(balance<2000.0) {
			System.out.println("Current Wallet Balance of MSG91 : " + balance + 
					'\n' + "Need Immediate action on the Current Wallet Balance." + '\n' + 
					"Please recharge the MSG91 Wallet Balance to continue the Services");
			
		}else {
			System.out.println("Current Wallet Balance of MSG91 : " + balance + '\n' +
					"Currently No Action is Required on MSG91 Wallet Balance.");
		}
		
		
		System.out.println('\n' + "Regards" + '\n' + "Amit Kumar");
		System.out.println("Thanks");
			
		
	}

}
