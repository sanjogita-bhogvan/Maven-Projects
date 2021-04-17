package com.qa.rest.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class GetCallBDD {

	@Test
	public void test_numberofCircuitsfor2017_Season() {
		given().
		when().
			get("http://ergast.com/api/f1/2017/circuits.json").
		then().
			assertThat().
			body("MRData.CircuitTable.Circuits.circuitId", hasSize(20)).
			statusCode(200).
			and().
			header("content-length", equalTo("4551"));
	}
	
	@Test
	public void getResponseBody() {
		   given().
			   	queryParam("CUSTOMER_ID","68195").
			   	queryParam("PASSWORD","1234!").
			   	queryParam("Account_No","1").
		   when().
		   get("http://demo.guru99.com/V4/sinkministatement.php").
		   then().
		   		assertThat().
		   		log().
		   		body();
	}
	
	@Test
	public void getResponseStatus() {
		int statusCode = given().
				queryParam("CUSTOMER_ID","68120").
			   	queryParam("PASSWORD","1234!").
			   	queryParam("Account_No","1").
		when().
				get("http://demo.guru99.com/V4/sinkministatement.php").
				getStatusCode();
		
		System.out.println("Response Code is: " + statusCode);	
		
	}
	
	@Test
	public void getResponseHeader() {
		System.out.println("The headers are: " + get("http://demo.guru99.com/V4/sinkministatement.php").then().extract().headers());
	}
	
	@Test
	public void getResponseTime() {
		System.out.println("Response Time is: " + get("http://demo.guru99.com/V4/sinkministatement.php").timeIn(TimeUnit.MILLISECONDS) + "milliseconds");
	}
	
	@Test
	public void getContentType() {
		System.out.println("Content Type: " + get("http://demo.guru99.com/V4/sinkministatement.php").then().extract().contentType());
	}
	
	@Test
	public static void getSpecificPartofResponse() {
		ArrayList<String> amounts = when().get("http://demo.guru99.com/V4/sinkministatement.php").then().extract().path("result.statements.AMOUNT");
		int sumOfAll = 0;
		for(String a:amounts) {
			System.out.println("The amount value fetched is: " + a);
			sumOfAll = sumOfAll + Integer.valueOf(a);
		}
		System.out.println("Total is" + sumOfAll);
	}
}
