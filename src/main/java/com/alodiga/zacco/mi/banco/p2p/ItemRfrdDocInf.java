/**
 * ItemRfrdDocInf.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.alodiga.zacco.mi.banco.p2p;



public class ItemRfrdDocInf  implements java.io.Serializable {
    private java.lang.String cdOrPrtry;

    private java.lang.String nb;

    private java.lang.String rltdDt;

    private java.lang.String rjctDt;

    private DuePyblAmt duePyblAmt;

    public ItemRfrdDocInf() {
    }

    public ItemRfrdDocInf(
           java.lang.String cdOrPrtry,
           java.lang.String nb,
           java.lang.String rltdDt,
           java.lang.String rjctDt,
           DuePyblAmt duePyblAmt) {
           this.cdOrPrtry = cdOrPrtry;
           this.nb = nb;
           this.rltdDt = rltdDt;
           this.rjctDt = rjctDt;
           this.duePyblAmt = duePyblAmt;
    }


    /**
     * Gets the cdOrPrtry value for this ItemRfrdDocInf.
     * 
     * @return cdOrPrtry
     */
    public java.lang.String getCdOrPrtry() {
        return cdOrPrtry;
    }


    /**
     * Sets the cdOrPrtry value for this ItemRfrdDocInf.
     * 
     * @param cdOrPrtry
     */
    public void setCdOrPrtry(java.lang.String cdOrPrtry) {
        this.cdOrPrtry = cdOrPrtry;
    }


    /**
     * Gets the nb value for this ItemRfrdDocInf.
     * 
     * @return nb
     */
    public java.lang.String getNb() {
        return nb;
    }


    /**
     * Sets the nb value for this ItemRfrdDocInf.
     * 
     * @param nb
     */
    public void setNb(java.lang.String nb) {
        this.nb = nb;
    }


    /**
     * Gets the rltdDt value for this ItemRfrdDocInf.
     * 
     * @return rltdDt
     */
    public java.lang.String getRltdDt() {
        return rltdDt;
    }


    /**
     * Sets the rltdDt value for this ItemRfrdDocInf.
     * 
     * @param rltdDt
     */
    public void setRltdDt(java.lang.String rltdDt) {
        this.rltdDt = rltdDt;
    }


    /**
     * Gets the rjctDt value for this ItemRfrdDocInf.
     * 
     * @return rjctDt
     */
    public java.lang.String getRjctDt() {
        return rjctDt;
    }


    /**
     * Sets the rjctDt value for this ItemRfrdDocInf.
     * 
     * @param rjctDt
     */
    public void setRjctDt(java.lang.String rjctDt) {
        this.rjctDt = rjctDt;
    }


    /**
     * Gets the duePyblAmt value for this ItemRfrdDocInf.
     * 
     * @return duePyblAmt
     */
    public DuePyblAmt getDuePyblAmt() {
        return duePyblAmt;
    }


    /**
     * Sets the duePyblAmt value for this ItemRfrdDocInf.
     * 
     * @param duePyblAmt
     */
    public void setDuePyblAmt(DuePyblAmt duePyblAmt) {
        this.duePyblAmt = duePyblAmt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ItemRfrdDocInf)) return false;
        ItemRfrdDocInf other = (ItemRfrdDocInf) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdOrPrtry==null && other.getCdOrPrtry()==null) || 
             (this.cdOrPrtry!=null &&
              this.cdOrPrtry.equals(other.getCdOrPrtry()))) &&
            ((this.nb==null && other.getNb()==null) || 
             (this.nb!=null &&
              this.nb.equals(other.getNb()))) &&
            ((this.rltdDt==null && other.getRltdDt()==null) || 
             (this.rltdDt!=null &&
              this.rltdDt.equals(other.getRltdDt()))) &&
            ((this.rjctDt==null && other.getRjctDt()==null) || 
             (this.rjctDt!=null &&
              this.rjctDt.equals(other.getRjctDt()))) &&
            ((this.duePyblAmt==null && other.getDuePyblAmt()==null) || 
             (this.duePyblAmt!=null &&
              this.duePyblAmt.equals(other.getDuePyblAmt())));
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
        if (getCdOrPrtry() != null) {
            _hashCode += getCdOrPrtry().hashCode();
        }
        if (getNb() != null) {
            _hashCode += getNb().hashCode();
        }
        if (getRltdDt() != null) {
            _hashCode += getRltdDt().hashCode();
        }
        if (getRjctDt() != null) {
            _hashCode += getRjctDt().hashCode();
        }
        if (getDuePyblAmt() != null) {
            _hashCode += getDuePyblAmt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ItemRfrdDocInf.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ItemRfrdDocInf"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdOrPrtry");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CdOrPrtry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nb");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Nb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rltdDt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "RltdDt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rjctDt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "RjctDt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duePyblAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DuePyblAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "DuePyblAmt"));
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
