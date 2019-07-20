package msft.contoso.webservices;

public class HelloAIMProxy implements msft.contoso.webservices.HelloAIM {
  private String _endpoint = null;
  private msft.contoso.webservices.HelloAIM helloAIM = null;
  
  public HelloAIMProxy() {
    _initHelloAIMProxy();
  }
  
  public HelloAIMProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloAIMProxy();
  }
  
  private void _initHelloAIMProxy() {
    try {
      helloAIM = (new msft.contoso.webservices.HelloAIMServiceLocator()).getHelloAIM();
      if (helloAIM != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)helloAIM)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)helloAIM)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (helloAIM != null)
      ((javax.xml.rpc.Stub)helloAIM)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public msft.contoso.webservices.HelloAIM getHelloAIM() {
    if (helloAIM == null)
      _initHelloAIMProxy();
    return helloAIM;
  }
  
  public java.lang.String sayHello(java.lang.String name) throws java.rmi.RemoteException{
    if (helloAIM == null)
      _initHelloAIMProxy();
    return helloAIM.sayHello(name);
  }
  
  
}