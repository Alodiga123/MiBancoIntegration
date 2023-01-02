/**
 * WsmibancoLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.alodiga.zacco.mi.banco.p2p;



public class WsmibancoLocator extends org.apache.axis.client.Service implements Wsmibanco {

    public WsmibancoLocator() {
    }


    public WsmibancoLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WsmibancoLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for wsmibancoSoap
    private java.lang.String wsmibancoSoap_address = "http://200.74.203.72:20504/wsmibanco.asmx";

    public java.lang.String getwsmibancoSoapAddress() {
        return wsmibancoSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String wsmibancoSoapWSDDServiceName = "wsmibancoSoap";

    public java.lang.String getwsmibancoSoapWSDDServiceName() {
        return wsmibancoSoapWSDDServiceName;
    }

    public void setwsmibancoSoapWSDDServiceName(java.lang.String name) {
        wsmibancoSoapWSDDServiceName = name;
    }

    public WsmibancoSoap getwsmibancoSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(wsmibancoSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getwsmibancoSoap(endpoint);
    }

    public WsmibancoSoap getwsmibancoSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            WsmibancoSoapStub _stub = new WsmibancoSoapStub(portAddress, this);
            _stub.setPortName(getwsmibancoSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setwsmibancoSoapEndpointAddress(java.lang.String address) {
        wsmibancoSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (WsmibancoSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                WsmibancoSoapStub _stub = new WsmibancoSoapStub(new java.net.URL(wsmibancoSoap_address), this);
                _stub.setPortName(getwsmibancoSoapWSDDServiceName());
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
        if ("wsmibancoSoap".equals(inputPortName)) {
            return getwsmibancoSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "wsmibanco");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "wsmibancoSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("wsmibancoSoap".equals(portName)) {
            setwsmibancoSoapEndpointAddress(address);
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
