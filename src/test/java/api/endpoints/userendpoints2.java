package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
//created for create,read,update,delete requests to the user api.
//userendpoints.java

import java.util.ResourceBundle;

import api.payload.User;


public class userendpoints2 {

	static ResourceBundle getURL()
	{
		
		ResourceBundle Routes = ResourceBundle.getBundle("Routes");//"Routes is properties file name
		
		return Routes;
	}
	
	
	
	
	public static Response create_user(User payload) {
		
		String post_url=getURL().getString("post_url");
		
		
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
	    .body(payload)
	    
	    
	    
		.when()
		.post(post_url);
		
	
		return response;
	}
	
	
	
	public static Response read_user(String username) {
	
    String get_url= getURL().getString("get_url");
		
	Response response =given()
	.pathParam("username", username)
    
    
    
	.when()
	.get(get_url);
	
	
	return response;}
	
	
	
public static Response update_user(String username,User payload) {
		
	   String update_url= getURL().getString("update_url");
	   
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
	    .body(payload)
	    
	    
	    
		.when()
		.put(update_url);
		
	
		return response;
	}


public static Response delete_user(String username) {
	
	   String delete_url= getURL().getString("delete_url");
	   
	Response response =given()
	.pathParam("username", username)
    
    
    
	.when()
	.delete(delete_url);
	

return response;}
	
}
  
