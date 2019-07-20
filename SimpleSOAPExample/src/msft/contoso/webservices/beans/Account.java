package msft.contoso.webservices.beans;

import java.io.Serializable;

public class Account implements Serializable{

	private static final long serialVersionUID = -5577579081118070434L;
	
	private String name;
	private String role;
	private String owner;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	@Override
	public String toString(){
		return name+"|"+owner+"|"+role;
	}
}