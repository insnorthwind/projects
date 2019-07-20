import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class WebserviceTester  {

   private Client client;
   private String REST_SERVICE_URL = "http://dev.contoso.msft:8080/SimpleRESTExample/aim/UserService/users";
   private String REST_SERVICE_JSON_URL = "http://dev.contoso.msft:8080/SimpleRESTExample/aim/UserService/usersjson";
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String PASS = "pass";
   private static final String FAIL = "fail";

   private void init(){
      this.client = ClientBuilder.newClient();
   }

   public static void main(String[] args){
      WebserviceTester tester = new WebserviceTester();
      //initialize the tester
      tester.init();
      //test get all users Web Service Method
      tester.testGetAllUsers();
      //test get user Web Service Method 
      tester.testGetUser();
      //test get user Web Service Method JSON 
      tester.testGetUserinJSON();
      //test update user Web Service Method
      tester.testUpdateUser();
      //test add user Web Service Method
      tester.testAddUser();
      //test delete user Web Service Method
      tester.testDeleteUser(2);
      //test add user Web Service Method JSON
      tester.testAddUserJSON();
      //test update user Web Service Method JSON
      tester.testUpdateUserJSON();
      //Cleaning up
      tester.testDeleteUser(3);
   }
   //Test: Get list of all users
   //Test: Check if list is not empty
   private void testGetAllUsers(){
	  GenericType<List<User>> list = new GenericType<List<User>>() {};
      List<User> users = client
         .target(REST_SERVICE_URL)
         .request(MediaType.APPLICATION_XML)
         .get(list);
      String result = PASS;
      if(users.isEmpty()){
         result = FAIL;
      }
      System.out.println("Test case name: testGetAllUsers, Result: " + result );
   }
   //Test: Get User of id 1
   //Test: Check if user is same as sample user
   private void testGetUser(){
      User sampleUser = new User();
      sampleUser.setId(1);

      User user = client
         .target(REST_SERVICE_URL)
         .path("/{userid}")
         .resolveTemplate("userid", 1)
         .request(MediaType.APPLICATION_XML)
         .get(User.class);
      String result = FAIL;
      if(sampleUser != null && sampleUser.getId() == user.getId()){
         result = PASS;
      }
      System.out.println("Test case name: testGetUser, Result: " + result );
   }
   //Test: Get User of id 1 in JSON
   //Test: Check if user is same as sample user
   private void testGetUserinJSON(){
      User sampleUser = new User();
      sampleUser.setId(1);

      User user = client
         .target(REST_SERVICE_JSON_URL)
         .path("/{userid}")
         .resolveTemplate("userid", 1)
         .request(MediaType.APPLICATION_JSON)
         .get(User.class);
      String result = FAIL;
      if(sampleUser != null && sampleUser.getId() == user.getId()){
         result = PASS;
      }
      System.out.println("Test case name: testGetUserinJSON, Result: " + result );
   }
   //Test: Update User of id 1
   //Test: Check if result is success XML.
   private void testUpdateUser(){
      Form form = new Form();
      form.param("id", "1");
      form.param("name", "david");
      form.param("role", "AIM System Owner");

      String callResult = client
         .target(REST_SERVICE_URL)
         .request(MediaType.APPLICATION_XML)
         .put(Entity.entity(form,
            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
            String.class);
      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testUpdateUser, Result: " + result );
   }
   //Test: Add User of id 2
   //Test: Check if result is success XML.
   private void testAddUser(){
      Form form = new Form();
      form.param("id", "2");
      form.param("name", "derisse");
      form.param("role", "AIM System Manager");

      String callResult = client
         .target(REST_SERVICE_URL)
         .request(MediaType.APPLICATION_XML)
         .post(Entity.entity(form,
            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
            String.class);
   
      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testAddUser, Result: " + result );
   }
   //Test: Delete User of id 2
   //Test: Check if result is success XML.
   private void testDeleteUser(int id){
      String callResult = client
         .target(REST_SERVICE_URL)
         .path("/{userid}")
         .resolveTemplate("userid", id)
         .request(MediaType.APPLICATION_XML)
         .delete(String.class);

      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testDeleteUser, Result: " + result );
   }
   //Test: Add User of id 3 using JSON
   //Test: Check if result is success.
   private void testAddUserJSON() {
	  String input = "{\"id\": 3,\"name\": \"bangsat\", \"role\": \"Cabo cibai\"}";

	  String callResult = client
	      .target(REST_SERVICE_JSON_URL)
	      .request(MediaType.APPLICATION_JSON)
	      .post(Entity.entity(input,
	         MediaType.APPLICATION_JSON),
	         String.class);
	   
	  String result = PASS;
	  if(!SUCCESS_RESULT.equals(callResult)){
	     result = FAIL;
	  }

	  System.out.println("Test case name: testAddUserinJSON, Result: " + result );
   }
   //Test: Update User of id 3
   //Test: Check if result is success XML.
   private void testUpdateUserJSON(){
	  String input = "{\"id\": 3,\"name\": \"perek\", \"role\": \"Pelacur\"}";

	  String callResult = client
		  .target(REST_SERVICE_JSON_URL)
		  .request(MediaType.APPLICATION_JSON)
		  .put(Entity.entity(input,
		     MediaType.APPLICATION_JSON),
		     String.class);
      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testUpdateUserinJSON, Result: " + result );
   }
}