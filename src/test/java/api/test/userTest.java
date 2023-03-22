package api.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userendpoints;
import api.endpoints.userendpoints2;
import api.payload.User;
import io.restassured.response.Response;

public class userTest {
	
	public static Faker faker;
	public static User userpayload;
	
	
	public static   Logger logger;
	

   @BeforeClass
	public static void setup() {
		
		
		faker=new Faker();
		userpayload=new User();
		
	userpayload.setId(faker.idNumber().hashCode());
	userpayload.setFirstName(faker.name().firstName());	
	userpayload.setLastName(faker.name().lastName());	
	userpayload.setEmail(faker.internet().emailAddress());	
	userpayload.setPhone(faker.phoneNumber().cellPhone());	
	userpayload.setPassword(faker.internet().password());
	userpayload.setUsername(faker.name().username());
	
	
	//logs
	logger = LogManager.getLogger();
}
  
	@Test(priority=1)
	public  void test_cerateuser(){
		logger.info("*************creating user**********");
		Response response=userendpoints2.create_user(userpayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	logger.info("*************user is created***********");
	}
	
	
	
	@Test(priority=2)
	public  void test_readuser() {
		logger.info("**********reading user**********");
	Response  response =userendpoints2.read_user(this.userpayload.getUsername());
	
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode() , 200);
		
		logger.info("***********user read already************");
	}
	
	
	@Test(priority=3)
	public  void test_updateuser() {
		
		logger.info("***********updating user************");
		
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		
		
		
	Response response=userendpoints2.update_user(this.userpayload.getUsername(), userpayload);
	response.then().log().all();
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode() , 200);
		
		Response responseafetrupdate =userendpoints2.read_user(this.userpayload.getUsername());
		Assert.assertEquals(responseafetrupdate.statusCode(), 200);
		
		logger.info("***********user is updated************");
		
	}
	
	
	
	@Test(priority=4)
	public  void delete_readuser() {
		
		logger.info("***********deleting user************");
	Response  response =userendpoints2.delete_user(this.userpayload.getUsername());
	
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode() , 200);
		
	logger.info("***********user is deleted************");
	
	}
	
	
}
