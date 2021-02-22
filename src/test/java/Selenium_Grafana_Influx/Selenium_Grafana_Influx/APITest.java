package Selenium_Grafana_Influx.Selenium_Grafana_Influx;

import org.json.simple.JSONObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import io.restassured.RestAssured;


// @Listeners(ExecutionListener.class) // Uncomment this if you want to run the API test cases only 
public class APITest extends BaseTest
{

	@Test(priority = 6,description = "Get API Test")
	public void get_Request_Test()
	{
	  Settings.testMode = "API_Testing";
	  Response response = RestAssured.get("https://reqres.in/api/users?page=2"); // We can change the URl
	  System.out.println("Executing get_Request_Test()");
	  System.out.println("Response :" + response.asString());
	  System.out.println("Response Status :" + response.statusCode());
	  Settings.statusCode = response.statusCode();
	  Settings.timer = response.time();
	  System.out.println("Response status line " + response.getStatusLine());
	}
  
	@Test(priority = 7,description = "Post API Test")
	public void post_Request_Test()
	{
	Settings.testMode = "API_Testing";	
	RestAssured.baseURI ="https://reqres.in/api/register";
	RequestSpecification request = RestAssured.given();
	JSONObject requestParams = new JSONObject();  // JSONObject is a class that represents a Simple JSON.
	requestParams.put("email", "eve.holt@reqres.in");  // We can add Key - Value pairs using the put method
	requestParams.put( "password", "pistol");
	request.header("Content-Type", "application/json");  // Add a header stating the Request body is a JSON
	request.body(requestParams.toJSONString()); // Add the Json to the body of the request
	Response response = request.post(); // Post the request and check the response
	System.out.println("Executing post_Request_Test()");
	System.out.println("Response:  " + response.asString());
	System.out.println("Response status : " + response.statusCode());
	Settings.statusCode = response.statusCode();
	Settings.timer = response.time();
	System.out.println("Response status line "+response.getStatusLine());
	}
	
  @Test(priority = 8,description = "Put API Test")
  public void put_Request_Test()
  {
	  Settings.testMode = "API_Testing";
	  int id = 2;
	  RestAssured.baseURI ="https://reqres.in/";
	  RequestSpecification request = RestAssured.given();
	  JSONObject requestParams = new JSONObject();
	  requestParams.put("name","morpheus"); 
	  requestParams.put("job" , "zion resident");	  
	  request.header("Content-Type", "application/json");	  
	  request.body(requestParams.toJSONString());	   
	  System.out.println("Executing put_Request_Test()");
	  Response response = request.put("/api/users/"+ id);
	  System.out.println("Response : "+response.asString());
	  System.out.println("Response status code: "+ response.statusCode());
	  Settings.statusCode = response.statusCode();
	  Settings.timer = response.time();
	  System.out.println("Response status line: "+ response.getStatusLine());		  
  }
  
  @Test(priority = 9,description = "Delete API Test")
  public void delete_Request_Test()
  {
	  int empid = 15410;
	  Settings.testMode = "API_Testing";
	  RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
	  RequestSpecification request = RestAssured.given(); 
	  request.header("Content-Type", "application/json"); 
	  Response response = request.delete("/delete/"+ empid); 
	  System.out.println("Executing delete_Request_Test()");
	  System.out.println("Response :" + response.asString());
	  System.out.println("Response status code: " + response.statusCode());
	  Settings.statusCode = response.statusCode();
	  Settings.timer = response.time();
	  System.out.println("Response status line:  "+ response.getStatusLine());	  
  }
  
  
}
