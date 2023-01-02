/**
 * SimfRespuestaValidacionLBTR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.alodiga.zacco.mi.banco.p2p;


public class SimfRespuestaValidacionLBTR  implements java.io.Serializable {
    private java.lang.String txSts;

    private java.lang.String rsn;

    public SimfRespuestaValidacionLBTR() {
    }

    public SimfRespuestaValidacionLBTR(
           java.lang.String txSts,
           java.lang.String rsn) {
           this.txSts = txSts;
           this.rsn = rsn;
    }


    /**
     * Gets the txSts value for this SimfRespuestaValidacionLBTR.
     * 
     * @return txSts
     */
    public java.lang.String getTxSts() {
        return txSts;
    }


    /**
     * Sets the txSts value for this SimfRespuestaValidacionLBTR.
     * 
     * @param txSts
     */
    public void setTxSts(java.lang.String txSts) {
        this.txSts = txSts;
    }


    /**
     * Gets the rsn value for this SimfRespuestaValidacionLBTR.
     * 
     * @return rsn
     */
    public java.lang.String getRsn() {
        return rsn;
    }


    /**
     * Sets the rsn value for this SimfRespuestaValidacionLBTR.
     * 
     * @param rsn
     */
    public void setRsn(java.lang.String rsn) {
        this.rsn = rsn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SimfRespuestaValidacionLBTR)) return false;
        SimfRespuestaValidacionLBTR other = (SimfRespuestaValidacionLBTR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.txSts==null && other.getTxSts()==null) || 
             (this.txSts!=null &&
              this.txSts.equals(other.getTxSts()))) &&
            ((this.rsn==null && other.getRsn()==null) || 
             (this.rsn!=null &&
              this.rsn.equals(other.getRsn())));
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
        if (getTxSts() != null) {
            _hashCode += getTxSts().hashCode();
        }
        if (getRsn() != null) {
            _hashCode += getRsn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SimfRespuestaValidacionLBTR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "simfRespuestaValidacionLBTR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("txSts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TxSts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rsn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Rsn"));
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
