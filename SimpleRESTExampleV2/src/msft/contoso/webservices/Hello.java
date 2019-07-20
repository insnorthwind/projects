package msft.contoso.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.HttpHeaders;

//Plain old Java Object it does not extend as class or implements an interface

//The class registers its methods for the HTTP GET request using the @GET annotation.
//Using the @Produces annotation, it defines that it can deliver several MIME types,
//text, XML and HTML.

//The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/hello")
public class Hello {
	  // This method is called if TEXT_PLAIN is request
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainTextHello() {
		  System.out.println("Calling Hello TEXT_PLAIN");
		  return "Hello (REST)";
	  }

	  // This method is called if XML is request
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public String sayXMLHello() {
		  System.out.println("Calling Hello TEXT_XML");
		  return "<?xml version=\"1.0\"?>" + "<hello>Hello (REST)" + "</hello>";
	  }

	  // This method is called if HTML is request
	  @GET
	  @Produces(MediaType.TEXT_HTML)
	  public String sayHtmlHello(@Context UriInfo uri, @Context HttpHeaders headers) {
		  System.out.println("Calling Hello TEXT_HTML");
		  return "<html>" + "<head><title>" + "Hello (REST)" + "</title>" +
				 "<meta http-equiv='Content-Type' content='text/html'></head>" +
	             "<body>" + "<div align='center'>Hello, I am a web service resource, " +
				 "and here is some of system info.<br></br>" +
	             "I am deployed at <b>" + uri.getAbsolutePath() + "</b></div><br>" +
				 "<div align='center'>Here are the request header<br></br>" +
	             "<b>" + this.writeHeaders(headers) + "</b></div>" +
				 "</body></html>";
	  }
	  
	  private String writeHeaders(HttpHeaders headers) {
		  StringBuilder buf = new StringBuilder();
		  for (String header: headers.getRequestHeaders().keySet()) {
			  buf.append(header);
			  buf.append(":");
			  buf.append(headers.getRequestHeader(header));
			  buf.append("<br>");
		  }
		  return buf.toString();
	  }
	  
	  @PUT
	  @Produces("text/html")
	  public String sayHelloBack(String requestEntity) {
		  System.out.println("Calling Hello PUT");
		  return "Hello " + requestEntity + ", from SimpleRESTExample!";
	  }
}