package msft.contoso.webservices.service;

import msft.contoso.webservices.beans.Account;

public interface AccountService {

	public boolean addAccount(Account p);
	
	public boolean deleteAccount(String name);
	
	public Account getAccount(String name);
	
	public Account[] getAllAccounts();
}
