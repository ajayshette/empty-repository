package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
//created for create,read,update,delete requests to the user api.
//userendpoints.java

import api.payload.User;


public class userendpoints {

	
	public static Response create_user(User payload) {
		
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
	    .body(payload)
	    
	    
	    
		.when()
		.post(Routes.post_url);
		
	
		return response;
	}
	
	
	
	public static Response read_user(String username) {
	
	Response response =given()
	.pathParam("username", username)
    
    
    
	.when()
	.get(Routes.get_url);
	
	
	return response;}
	
	
	
public static Response update_user(String username,User payload) {
		
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
	    .body(payload)
	    
	    
	    
		.when()
		.put(Routes.put_url);
		
	
		return response;
	}


public static Response delete_user(String username) {
	
	Response response =given()
	.pathParam("username", username)
    
    
    
	.when()
	.delete(Routes.delete_url);
	

return response;}
	
}
  