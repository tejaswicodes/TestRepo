package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class Test_GET {

	@Test
	public void getTest()
	{
		Response response = get("https://reqres.in/api/users/2");
		
		System.out.println(response.getBody().asString());
		System.out.println(response.getContentType());
		System.out.println(response.getStatusLine());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test
	public void getTestStaticImport()
	{
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.body("data.id[0]" , equalTo(7));
		
		System.out.println(given()
		.get("https://reqres.in/api/users?page=2")
		 .then().body("data.id[0]", equalTo(7)));
	}


}
