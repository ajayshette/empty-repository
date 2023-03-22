package api.test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Routes;
import api.endpoints.userendpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DDtest {

@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
public void  testcreate_user(String userID,String username,String fname,String lname,String usermail,String pwd,String ph) {
		
	User userpayload = new User();
	
	userpayload.setId(Integer.parseInt(userID));
	userpayload.setFirstName(fname);
	userpayload.setLastName(lname);
	userpayload.setPassword(pwd);
	userpayload.setEmail(usermail);
	userpayload.setUsername(username);
	userpayload.setPhone(ph);
	
	Response response=userendpoints.create_user(userpayload);
	Assert.assertEquals(response.getStatusCode(), 200);
	
	
	
	
	
	}

@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
public void  testdelete_user(String username) {
	
	Response response=userendpoints.delete_user(username);
	Assert.assertEquals(response.getStatusCode(), 200);
}
	
	
	
	
	
}
