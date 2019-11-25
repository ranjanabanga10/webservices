package webserviceAssignment;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;



public class getInfoofStudent {
	
	@Test
	void test001() {
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		RestAssured.basePath="/posts";
		
		RequestSpecification httpRequest=RestAssured.given().contentType(ContentType.JSON);
		Response response=httpRequest.log().all().get("/61");
		String title=httpRequest.log().all().get("/61").then().extract().path("title");
		
		response.prettyPrint();
		
		System.out.println("Title is::"+title);
		
		
		
//		//Specify base URI
//		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
//		
//		//Request object
//		RequestSpecification httpRequest=RestAssured.given();
//		
//		//Response object
//		Response response=httpRequest.request(Method.GET,"/posts");
//		
//		
//		//Retrieve the body of the Response
//		ResponseBody body=response.getBody();
//		String bodyAsString=body.asString();
//		System.out.println("Response Body is::"+bodyAsString);
//		
//		//print response in console window
//		String responseBody=response.getBody().asString();
//		System.out.println("Response Body is:"+responseBody);
//		
//		//Status code validation
//		int statusCode=response.getStatusCode();
//		System.out.println("Status code is::"+statusCode);
//		Assert.assertEquals(statusCode, 200);
//		
//		//Status line verification
//		String statusLine=response.getStatusLine();
//		System.out.println(statusLine);
//		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	

}
