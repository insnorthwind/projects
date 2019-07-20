package msft.contoso.webservices;

public class HelloAIM {

	public String sayHello(String name) {
		System.out.println("Calling HelloAIM : " + name);
		return "Hello (from AIM) "+ name;
	}

}
