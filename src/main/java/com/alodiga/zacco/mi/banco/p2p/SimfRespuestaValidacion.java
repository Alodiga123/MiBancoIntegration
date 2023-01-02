/**
 * SimfRespuestaValidacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.alodiga.zacco.mi.banco.p2p;



public class SimfRespuestaValidacion  implements java.io.Serializable {
    private java.lang.String txSts;

    private java.lang.String rsn;

    private java.lang.String cdtrAcctTp;

    private java.lang.String cdtrAcctId;

    private java.lang.String addtlInf;

    public SimfRespuestaValidacion() {
    }

    public SimfRespuestaValidacion(
           java.lang.String txSts,
           java.lang.String rsn,
           java.lang.String cdtrAcctTp,
           java.lang.String cdtrAcctId,
           java.lang.String addtlInf) {
           this.txSts = txSts;
           this.rsn = rsn;
           this.cdtrAcctTp = cdtrAcctTp;
           this.cdtrAcctId = cdtrAcctId;
           this.addtlInf = addtlInf;
    }


    /**
     * Gets the txSts value for this SimfRespuestaValidacion.
     * 
     * @return txSts
     */
    public java.lang.String getTxSts() {
        return txSts;
    }


    /**
     * Sets the txSts value for this SimfRespuestaValidacion.
     * 
     * @param txSts
     */
    public void setTxSts(java.lang.String txSts) {
        this.txSts = txSts;
    }


    /**
     * Gets the rsn value for this SimfRespuestaValidacion.
     * 
     * @return rsn
     */
    public java.lang.String getRsn() {
        return rsn;
    }


    /**
     * Sets the rsn value for this SimfRespuestaValidacion.
     * 
     * @param rsn
     */
    public void setRsn(java.lang.String rsn) {
        this.rsn = rsn;
    }


    /**
     * Gets the cdtrAcctTp value for this SimfRespuestaValidacion.
     * 
     * @return cdtrAcctTp
     */
    public java.lang.String getCdtrAcctTp() {
        return cdtrAcctTp;
    }


    /**
     * Sets the cdtrAcctTp value for this SimfRespuestaValidacion.
     * 
     * @param cdtrAcctTp
     */
    public void setCdtrAcctTp(java.lang.String cdtrAcctTp) {
        this.cdtrAcctTp = cdtrAcctTp;
    }


    /**
     * Gets the cdtrAcctId value for this SimfRespuestaValidacion.
     * 
     * @return cdtrAcctId
     */
    public java.lang.String getCdtrAcctId() {
        return cdtrAcctId;
    }


    /**
     * Sets the cdtrAcctId value for this SimfRespuestaValidacion.
     * 
     * @param cdtrAcctId
     */
    public void setCdtrAcctId(java.lang.String cdtrAcctId) {
        this.cdtrAcctId = cdtrAcctId;
    }


    /**
     * Gets the addtlInf value for this SimfRespuestaValidacion.
     * 
     * @return addtlInf
     */
    public java.lang.String getAddtlInf() {
        return addtlInf;
    }


    /**
     * Sets the addtlInf value for this SimfRespuestaValidacion.
     * 
     * @param addtlInf
     */
    public void setAddtlInf(java.lang.String addtlInf) {
        this.addtlInf = addtlInf;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SimfRespuestaValidacion)) return false;
        SimfRespuestaValidacion other = (SimfRespuestaValidacion) obj;
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
              this.rsn.equals(other.getRsn()))) &&
            ((this.cdtrAcctTp==null && other.getCdtrAcctTp()==null) || 
             (this.cdtrAcctTp!=null &&
              this.cdtrAcctTp.equals(other.getCdtrAcctTp()))) &&
            ((this.cdtrAcctId==null && other.getCdtrAcctId()==null) || 
             (this.cdtrAcctId!=null &&
              this.cdtrAcctId.equals(other.getCdtrAcctId()))) &&
            ((this.addtlInf==null && other.getAddtlInf()==null) || 
             (this.addtlInf!=null &&
              this.addtlInf.equals(other.getAddtlInf())));
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
        if (getCdtrAcctTp() != null) {
            _hashCode += getCdtrAcctTp().hashCode();
        }
        if (getCdtrAcctId() != null) {
            _hashCode += getCdtrAcctId().hashCode();
        }
        if (getAddtlInf() != null) {
            _hashCode += getAddtlInf().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SimfRespuestaValidacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "simfRespuestaValidacion"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtrAcctTp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CdtrAcctTp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtrAcctId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CdtrAcctId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addtlInf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AddtlInf"));
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
