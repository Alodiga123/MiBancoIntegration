/**
 * BloqDesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.alodiga.zacco.mi.banco.p2p;



public class BloqDesResponse  implements java.io.Serializable {
    private MibancoResponse bloqDesResult;

    public BloqDesResponse() {
    }

    public BloqDesResponse(
           MibancoResponse bloqDesResult) {
           this.bloqDesResult = bloqDesResult;
    }


    /**
     * Gets the bloqDesResult value for this BloqDesResponse.
     * 
     * @return bloqDesResult
     */
    public MibancoResponse getBloqDesResult() {
        return bloqDesResult;
    }


    /**
     * Sets the bloqDesResult value for this BloqDesResponse.
     * 
     * @param bloqDesResult
     */
    public void setBloqDesResult(MibancoResponse bloqDesResult) {
        this.bloqDesResult = bloqDesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BloqDesResponse)) return false;
        BloqDesResponse other = (BloqDesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bloqDesResult==null && other.getBloqDesResult()==null) || 
             (this.bloqDesResult!=null &&
              this.bloqDesResult.equals(other.getBloqDesResult())));
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
        if (getBloqDesResult() != null) {
            _hashCode += getBloqDesResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BloqDesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">bloqDesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bloqDesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "bloqDesResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "MibancoResponse"));
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
