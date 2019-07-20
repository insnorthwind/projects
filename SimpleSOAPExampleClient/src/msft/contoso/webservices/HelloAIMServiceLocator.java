/**
 * HelloAIMServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package msft.contoso.webservices;

public class HelloAIMServiceLocator extends org.apache.axis.client.Service implements msft.contoso.webservices.HelloAIMService {

    public HelloAIMServiceLocator() {
    }


    public HelloAIMServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HelloAIMServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HelloAIM
    private java.lang.String HelloAIM_address = "http://192.168.119.88:8080/SimpleSOAPExample/services/HelloAIM";

    public java.lang.String getHelloAIMAddress() {
        return HelloAIM_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloAIMWSDDServiceName = "HelloAIM";

    public java.lang.String getHelloAIMWSDDServiceName() {
        return HelloAIMWSDDServiceName;
    }

    public void setHelloAIMWSDDServiceName(java.lang.String name) {
        HelloAIMWSDDServiceName = name;
    }

    public msft.contoso.webservices.HelloAIM getHelloAIM() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloAIM_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloAIM(endpoint);
    }

    public msft.contoso.webservices.HelloAIM getHelloAIM(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            msft.contoso.webservices.HelloAIMSoapBindingStub _stub = new msft.contoso.webservices.HelloAIMSoapBindingStub(portAddress, this);
            _stub.setPortName(getHelloAIMWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloAIMEndpointAddress(java.lang.String address) {
        HelloAIM_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (msft.contoso.webservices.HelloAIM.class.isAssignableFrom(serviceEndpointInterface)) {
                msft.contoso.webservices.HelloAIMSoapBindingStub _stub = new msft.contoso.webservices.HelloAIMSoapBindingStub(new java.net.URL(HelloAIM_address), this);
                _stub.setPortName(getHelloAIMWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("HelloAIM".equals(inputPortName)) {
            return getHelloAIM();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.contoso.msft", "HelloAIMService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.contoso.msft", "HelloAIM"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HelloAIM".equals(portName)) {
            setHelloAIMEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
