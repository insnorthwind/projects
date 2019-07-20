package msft.contoso.webservices;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;

//import java.util.concurrent.TimeUnit;

@Path("/UserService")
public class UserService {

   UserDao userDao = new UserDao();
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String FAILURE_RESULT="<result>failure</result>";

   @GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   public List<User> getUsers(){
	  System.out.println("Get ALL users");
      return userDao.getAllUsers();
   }

   @GET
   @Path("/users/{userid}")
   @Produces(MediaType.APPLICATION_XML)
   public User getUser(@PathParam("userid") int userid){
	  System.out.println("Get user: " + Integer.toString(userid));
      return userDao.getUser(userid);
   }
   
   @GET
   @Path("/users/count")
   @Produces(MediaType.TEXT_PLAIN)
   public int countUser(){
	  System.out.println("Count users: " + userDao.countUsers());
      return userDao.countUsers();
   }
   
   @GET
   @Path("/usersjson")
   @Produces(MediaType.APPLICATION_JSON)
   public List<User> getUsersJSON(){
	  System.out.println("Get ALL users in JSON");
      return userDao.getAllUsers();
   }

   @GET
   @Path("/usersjson/{userid}")
   @Produces(MediaType.APPLICATION_JSON)
   public User getUserJSON(@PathParam("userid") int userid){
	  System.out.println("Get user in JSON: " + Integer.toString(userid));
      return userDao.getUser(userid);
   }

   @POST
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String createUser(@FormParam("id") int id,
      @FormParam("name") String name,
      @FormParam("role") String role,
      @Context HttpServletResponse servletResponse) throws IOException{
      User user = new User(id, name, role);
      int result = userDao.addUser(user);
      if(result == 1){
    	  //To simulate timeout
    	  /**
    	  try {
			TimeUnit.SECONDS.sleep(65);
		  } catch (InterruptedException e) {
			e.printStackTrace();
		  }
		  **/
    	  System.out.println("Add user SUCCESS: " + Integer.toString(id) + "," + name + "," + role);
          return SUCCESS_RESULT;
      }
      System.out.println("Add user FAILED: " + Integer.toString(id) + "," + name + "," + role);
      return FAILURE_RESULT;
   }
   
   @POST
   @Path("/usersjson")
   @Consumes(MediaType.APPLICATION_JSON)
   public String createUserJSON(User user) {
      int result = userDao.addUser(user);
      if(result == 1){
    	  //To simulate timeout
    	  /**
    	  try {
			TimeUnit.SECONDS.sleep(65);
		  } catch (InterruptedException e) {
			e.printStackTrace();
		  }
		  **/
    	  System.out.println("Add user JSON SUCCESS");
    	  return SUCCESS_RESULT;
      }
      System.out.println("Add user JSON FAILED");
      //return Response.status(201).entity(result).build();
      return FAILURE_RESULT;
   }
   
   @PUT
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String updateUser(@FormParam("id") int id,
      @FormParam("name") String name,
      @FormParam("role") String role,
      @Context HttpServletResponse servletResponse) throws IOException{
      User user = new User(id, name, role);
      int result = userDao.updateUser(user);
      if(result == 1){
    	  //To simulate timeout
    	  /**
    	  try {
    		  TimeUnit.SECONDS.sleep(65);
		  } catch (InterruptedException e) {
			e.printStackTrace();
		  }
		  **/
    	  System.out.println("Update user SUCCESS: " + Integer.toString(id) + "," + name + "," + role);
          return SUCCESS_RESULT;
      }
      System.out.println("Update user FAILED: " + Integer.toString(id) + "," + name + "," + role);
      return FAILURE_RESULT;
   }
   
   @PUT
   @Path("/usersjson")
   @Consumes(MediaType.APPLICATION_JSON)
   public String updateUserJSON(User user) {
      int result = userDao.updateUser(user);
      if(result == 1){
    	  //To simulate timeout
    	  /**
    	  try {
    		  TimeUnit.SECONDS.sleep(65);
		  } catch (InterruptedException e) {
			e.printStackTrace();
		  }
		  **/
    	  System.out.println("Update user JSON SUCCESS");
          return SUCCESS_RESULT;
      }
      System.out.println("Update user JSON FAILED");
      return FAILURE_RESULT;
   }

   @DELETE
   @Path("/users/{userid}")
   @Produces(MediaType.APPLICATION_XML)
   public String deleteUser(@PathParam("userid") int userid){
      int result = userDao.deleteUser(userid);
      if(result == 1){
    	  //To simulate timeout
    	  /**
    	  try {
    		  TimeUnit.SECONDS.sleep(65);
		  } catch (InterruptedException e) {
			e.printStackTrace();
		  }
		  **/
    	  System.out.println("Delete user SUCCESS: " + Integer.toString(userid));
          return SUCCESS_RESULT;
      }
      System.out.println("Delete user FAILED: " + Integer.toString(userid));
      return FAILURE_RESULT;
   }
   
   @OPTIONS
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   public String getSupportedOperations(){
	  System.out.println("Get Options");
      return "<operations>GET, PUT, POST, DELETE</operations>";
   }
}