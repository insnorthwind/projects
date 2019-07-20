package msft.contoso.webservices.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import msft.contoso.webservices.beans.Account;

public class AccountServiceImpl implements AccountService {

	private static Map<String,Account> accounts = new HashMap<String,Account>();
	
	@Override
	public boolean addAccount(Account a) {
		System.out.println("Calling SOAP addAccount");
		if ((accounts.get(a.getName()) != null) || (a.getName().equalsIgnoreCase("passerr"))) return false;
		System.out.println("Calling SOAP addAccount");
		accounts.put(a.getName(), a);
		return true;
	}

	@Override
	public boolean deleteAccount(String name) {
		System.out.println("Calling SOAP deleteAccount");
		if(accounts.get(name) == null) return false;
		accounts.remove(name);
		return true;
	}

	@Override
	public Account getAccount(String name) {
		System.out.println("Calling SOAP getAccount");
		return accounts.get(name);
	}

	@Override
	public Account[] getAllAccounts() {
		System.out.println("Calling SOAP getAllAccount");
		Set<String> names = accounts.keySet();
		Account[] a = new Account[names.size()];
		int i=0;
		for(String name : names){
			a[i] = accounts.get(name);
			i++;
		}
		return a;
	}
}