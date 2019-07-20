/**
 * AccountServiceImplService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package msft.contoso.webservices.service;

public interface AccountServiceImplService extends javax.xml.rpc.Service {
    public java.lang.String getAccountServiceImplAddress();

    public msft.contoso.webservices.service.AccountServiceImpl getAccountServiceImpl() throws javax.xml.rpc.ServiceException;

    public msft.contoso.webservices.service.AccountServiceImpl getAccountServiceImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
