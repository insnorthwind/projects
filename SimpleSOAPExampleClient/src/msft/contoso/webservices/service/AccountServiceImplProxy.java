package msft.contoso.webservices.service;

public class AccountServiceImplProxy implements msft.contoso.webservices.service.AccountServiceImpl {
  private String _endpoint = null;
  private msft.contoso.webservices.service.AccountServiceImpl accountServiceImpl = null;
  
  public AccountServiceImplProxy() {
    _initAccountServiceImplProxy();
  }
  
  public AccountServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initAccountServiceImplProxy();
  }
  
  private void _initAccountServiceImplProxy() {
    try {
      accountServiceImpl = (new msft.contoso.webservices.service.AccountServiceImplServiceLocator()).getAccountServiceImpl();
      if (accountServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)accountServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)accountServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (accountServiceImpl != null)
      ((javax.xml.rpc.Stub)accountServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public msft.contoso.webservices.service.AccountServiceImpl getAccountServiceImpl() {
    if (accountServiceImpl == null)
      _initAccountServiceImplProxy();
    return accountServiceImpl;
  }
  
  public msft.contoso.webservices.beans.Account getAccount(java.lang.String name) throws java.rmi.RemoteException{
    if (accountServiceImpl == null)
      _initAccountServiceImplProxy();
    return accountServiceImpl.getAccount(name);
  }
  
  public boolean addAccount(msft.contoso.webservices.beans.Account a) throws java.rmi.RemoteException{
    if (accountServiceImpl == null)
      _initAccountServiceImplProxy();
    return accountServiceImpl.addAccount(a);
  }
  
  public boolean deleteAccount(java.lang.String name) throws java.rmi.RemoteException{
    if (accountServiceImpl == null)
      _initAccountServiceImplProxy();
    return accountServiceImpl.deleteAccount(name);
  }
  
  public msft.contoso.webservices.beans.Account[] getAllAccounts() throws java.rmi.RemoteException{
    if (accountServiceImpl == null)
      _initAccountServiceImplProxy();
    return accountServiceImpl.getAllAccounts();
  }
  
  
}