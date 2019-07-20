/**
 * HelloAIMService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package msft.contoso.webservices;

public interface HelloAIMService extends javax.xml.rpc.Service {
    public java.lang.String getHelloAIMAddress();

    public msft.contoso.webservices.HelloAIM getHelloAIM() throws javax.xml.rpc.ServiceException;

    public msft.contoso.webservices.HelloAIM getHelloAIM(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
