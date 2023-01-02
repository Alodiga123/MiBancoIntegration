/**
 * GetInforCliente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.alodiga.zacco.mi.banco.p2p;



public class GetInforCliente  implements java.io.Serializable {
    private java.lang.String numIdentificacion;

    private java.lang.String secuencial;

    private java.lang.String apiKey;

    private java.lang.String firma;

    public GetInforCliente() {
    }

    public GetInforCliente(
           java.lang.String numIdentificacion,
           java.lang.String secuencial,
           java.lang.String apiKey,
           java.lang.String firma) {
           this.numIdentificacion = numIdentificacion;
           this.secuencial = secuencial;
           this.apiKey = apiKey;
           this.firma = firma;
    }


    /**
     * Gets the numIdentificacion value for this GetInforCliente.
     * 
     * @return numIdentificacion
     */
    public java.lang.String getNumIdentificacion() {
        return numIdentificacion;
    }


    /**
     * Sets the numIdentificacion value for this GetInforCliente.
     * 
     * @param numIdentificacion
     */
    public void setNumIdentificacion(java.lang.String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }


    /**
     * Gets the secuencial value for this GetInforCliente.
     * 
     * @return secuencial
     */
    public java.lang.String getSecuencial() {
        return secuencial;
    }


    /**
     * Sets the secuencial value for this GetInforCliente.
     * 
     * @param secuencial
     */
    public void setSecuencial(java.lang.String secuencial) {
        this.secuencial = secuencial;
    }


    /**
     * Gets the apiKey value for this GetInforCliente.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this GetInforCliente.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the firma value for this GetInforCliente.
     * 
     * @return firma
     */
    public java.lang.String getFirma() {
        return firma;
    }


    /**
     * Sets the firma value for this GetInforCliente.
     * 
     * @param firma
     */
    public void setFirma(java.lang.String firma) {
        this.firma = firma;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetInforCliente)) return false;
        GetInforCliente other = (GetInforCliente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numIdentificacion==null && other.getNumIdentificacion()==null) || 
             (this.numIdentificacion!=null &&
              this.numIdentificacion.equals(other.getNumIdentificacion()))) &&
            ((this.secuencial==null && other.getSecuencial()==null) || 
             (this.secuencial!=null &&
              this.secuencial.equals(other.getSecuencial()))) &&
            ((this.apiKey==null && other.getApiKey()==null) || 
             (this.apiKey!=null &&
              this.apiKey.equals(other.getApiKey()))) &&
            ((this.firma==null && other.getFirma()==null) || 
             (this.firma!=null &&
              this.firma.equals(other.getFirma())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getNumIdentificacion() != null) {
            _hashCode += getNumIdentificacion().hashCode();
        }
        if (getSecuencial() != null) {
            _hashCode += getSecuencial().hashCode();
        }
        if (getApiKey() != null) {
            _hashCode += getApiKey().hashCode();
        }
        if (getFirma() != null) {
            _hashCode += getFirma().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetInforCliente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">getInforCliente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numIdentificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NumIdentificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secuencial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "secuencial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "apiKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firma");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "firma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
