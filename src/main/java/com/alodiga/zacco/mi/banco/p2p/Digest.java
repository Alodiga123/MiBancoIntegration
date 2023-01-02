/**
 * Digest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.alodiga.zacco.mi.banco.p2p;



public class Digest  implements java.io.Serializable {
    private java.lang.String datos;

    private java.lang.String secreto;

    public Digest() {
    }

    public Digest(
           java.lang.String datos,
           java.lang.String secreto) {
           this.datos = datos;
           this.secreto = secreto;
    }


    /**
     * Gets the datos value for this Digest.
     * 
     * @return datos
     */
    public java.lang.String getDatos() {
        return datos;
    }


    /**
     * Sets the datos value for this Digest.
     * 
     * @param datos
     */
    public void setDatos(java.lang.String datos) {
        this.datos = datos;
    }


    /**
     * Gets the secreto value for this Digest.
     * 
     * @return secreto
     */
    public java.lang.String getSecreto() {
        return secreto;
    }


    /**
     * Sets the secreto value for this Digest.
     * 
     * @param secreto
     */
    public void setSecreto(java.lang.String secreto) {
        this.secreto = secreto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Digest)) return false;
        Digest other = (Digest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.datos==null && other.getDatos()==null) || 
             (this.datos!=null &&
              this.datos.equals(other.getDatos()))) &&
            ((this.secreto==null && other.getSecreto()==null) || 
             (this.secreto!=null &&
              this.secreto.equals(other.getSecreto())));
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
        if (getDatos() != null) {
            _hashCode += getDatos().hashCode();
        }
        if (getSecreto() != null) {
            _hashCode += getSecreto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Digest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">digest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "datos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secreto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "secreto"));
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
