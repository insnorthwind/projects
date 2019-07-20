import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class WebserviceLoadTester {

	private Client client;
	private String REST_SERVICE_JSON_URL = "http://dev.contoso.msft:8080/SimpleRESTExample/aim/UserService/usersjson";
	private static final String SUCCESS_RESULT="<result>success</result>";
	private static final String PASS = "pass";
	private static final String FAIL = "fail";
	private static final String FILENAME = "ws-input.txt";

	private void init(){
	      this.client = ClientBuilder.newClient();
	}

	public static void main(String[] args) {
		//String input = "";
		
		WebserviceLoadTester tester = new WebserviceLoadTester();
	    //initialize the tester
	    tester.init();
	    
	    System.out.println("Load Test START...");
		try {
			System.out.println("Reading input file [" + FILENAME + "]...");
			InputStream fis = new FileInputStream(FILENAME);
			InputStreamReader fisr = new InputStreamReader(fis);
			
			BufferedReader br = new BufferedReader(fisr);
			String line;
			while ((line = br.readLine()) != null) {
				//input += line + "\n";
				System.out.println(line);
				tester.testAddUserJSON(line);
			}
			
			br.close();
			//System.out.println(input);
			System.out.println("Load Test COMPLETED!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void testAddUserJSON(String input) {

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

	    System.out.println("Load Test [" + input + "]: " + result );
    }
}
