/**
 * DuePyblAmt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.alodiga.zacco.mi.banco.p2p;


public class DuePyblAmt  implements java.io.Serializable {
    private java.lang.String ccy;

    private double amt;

    public DuePyblAmt() {
    }

    public DuePyblAmt(
           java.lang.String ccy,
           double amt) {
           this.ccy = ccy;
           this.amt = amt;
    }


    /**
     * Gets the ccy value for this DuePyblAmt.
     * 
     * @return ccy
     */
    public java.lang.String getCcy() {
        return ccy;
    }


    /**
     * Sets the ccy value for this DuePyblAmt.
     * 
     * @param ccy
     */
    public void setCcy(java.lang.String ccy) {
        this.ccy = ccy;
    }


    /**
     * Gets the amt value for this DuePyblAmt.
     * 
     * @return amt
     */
    public double getAmt() {
        return amt;
    }


    /**
     * Sets the amt value for this DuePyblAmt.
     * 
     * @param amt
     */
    public void setAmt(double amt) {
        this.amt = amt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DuePyblAmt)) return false;
        DuePyblAmt other = (DuePyblAmt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ccy==null && other.getCcy()==null) || 
             (this.ccy!=null &&
              this.ccy.equals(other.getCcy()))) &&
            this.amt == other.getAmt();
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
        if (getCcy() != null) {
            _hashCode += getCcy().hashCode();
        }
        _hashCode += new Double(getAmt()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DuePyblAmt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "DuePyblAmt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccy");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Ccy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Amt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
