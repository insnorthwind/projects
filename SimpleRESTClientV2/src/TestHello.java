import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class TestHello {

	public static void main(String[] args) {
        ClientConfig config = new ClientConfig();

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(getBaseURI());

        String response = target.path("aim").
                            path("hello").
                            request().
                            accept(MediaType.TEXT_PLAIN).
                            get(Response.class)
                            .toString();

        String plainAnswer = target.path("aim").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class);
        String xmlAnswer = target.path("aim").path("hello").request().accept(MediaType.TEXT_XML).get(String.class);
        String htmlAnswer = target.path("aim").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class);
        
        System.out.println("Response:");
        System.out.println(response);
        System.out.println("");
        System.out.println("Plain Text Response:");
        System.out.println(plainAnswer);
        System.out.println("");
        System.out.println("XML Response:");
        System.out.println(xmlAnswer);
        System.out.println("");
        System.out.println("HTML Response:");
        System.out.println(htmlAnswer);
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://dev.contoso.msft:8080/SimpleRESTExample").build();
	}
}