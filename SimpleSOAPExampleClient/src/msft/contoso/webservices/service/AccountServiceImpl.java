/**
 * AccountServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package msft.contoso.webservices.service;

public interface AccountServiceImpl extends java.rmi.Remote {
    public msft.contoso.webservices.beans.Account getAccount(java.lang.String name) throws java.rmi.RemoteException;
    public boolean addAccount(msft.contoso.webservices.beans.Account a) throws java.rmi.RemoteException;
    public boolean deleteAccount(java.lang.String name) throws java.rmi.RemoteException;
    public msft.contoso.webservices.beans.Account[] getAllAccounts() throws java.rmi.RemoteException;
}
