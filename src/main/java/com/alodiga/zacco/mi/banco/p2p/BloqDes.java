/**
 * BloqDes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.alodiga.zacco.mi.banco.p2p;



public class BloqDes  implements java.io.Serializable {
    private java.lang.String cuenta;

    private java.lang.String accion;

    private java.lang.String causa;

    private java.math.BigDecimal monto;

    private int secuencial;

    private int plazo;

    private java.lang.String apiKey;

    private java.lang.String firma;

    public BloqDes() {
    }

    public BloqDes(
           java.lang.String cuenta,
           java.lang.String accion,
           java.lang.String causa,
           java.math.BigDecimal monto,
           int secuencial,
           int plazo,
           java.lang.String apiKey,
           java.lang.String firma) {
           this.cuenta = cuenta;
           this.accion = accion;
           this.causa = causa;
           this.monto = monto;
           this.secuencial = secuencial;
           this.plazo = plazo;
           this.apiKey = apiKey;
           this.firma = firma;
    }


    /**
     * Gets the cuenta value for this BloqDes.
     * 
     * @return cuenta
     */
    public java.lang.String getCuenta() {
        return cuenta;
    }


    /**
     * Sets the cuenta value for this BloqDes.
     * 
     * @param cuenta
     */
    public void setCuenta(java.lang.String cuenta) {
        this.cuenta = cuenta;
    }


    /**
     * Gets the accion value for this BloqDes.
     * 
     * @return accion
     */
    public java.lang.String getAccion() {
        return accion;
    }


    /**
     * Sets the accion value for this BloqDes.
     * 
     * @param accion
     */
    public void setAccion(java.lang.String accion) {
        this.accion = accion;
    }


    /**
     * Gets the causa value for this BloqDes.
     * 
     * @return causa
     */
    public java.lang.String getCausa() {
        return causa;
    }


    /**
     * Sets the causa value for this BloqDes.
     * 
     * @param causa
     */
    public void setCausa(java.lang.String causa) {
        this.causa = causa;
    }


    /**
     * Gets the monto value for this BloqDes.
     * 
     * @return monto
     */
    public java.math.BigDecimal getMonto() {
        return monto;
    }


    /**
     * Sets the monto value for this BloqDes.
     * 
     * @param monto
     */
    public void setMonto(java.math.BigDecimal monto) {
        this.monto = monto;
    }


    /**
     * Gets the secuencial value for this BloqDes.
     * 
     * @return secuencial
     */
    public int getSecuencial() {
        return secuencial;
    }


    /**
     * Sets the secuencial value for this BloqDes.
     * 
     * @param secuencial
     */
    public void setSecuencial(int secuencial) {
        this.secuencial = secuencial;
    }


    /**
     * Gets the plazo value for this BloqDes.
     * 
     * @return plazo
     */
    public int getPlazo() {
        return plazo;
    }


    /**
     * Sets the plazo value for this BloqDes.
     * 
     * @param plazo
     */
    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }


    /**
     * Gets the apiKey value for this BloqDes.
     * 
     * @return apiKey
     */
    public java.lang.String getApiKey() {
        return apiKey;
    }


    /**
     * Sets the apiKey value for this BloqDes.
     * 
     * @param apiKey
     */
    public void setApiKey(java.lang.String apiKey) {
        this.apiKey = apiKey;
    }


    /**
     * Gets the firma value for this BloqDes.
     * 
     * @return firma
     */
    public java.lang.String getFirma() {
        return firma;
    }


    /**
     * Sets the firma value for this BloqDes.
     * 
     * @param firma
     */
    public void setFirma(java.lang.String firma) {
        this.firma = firma;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BloqDes)) return false;
        BloqDes other = (BloqDes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cuenta==null && other.getCuenta()==null) || 
             (this.cuenta!=null &&
              this.cuenta.equals(other.getCuenta()))) &&
            ((this.accion==null && other.getAccion()==null) || 
             (this.accion!=null &&
              this.accion.equals(other.getAccion()))) &&
            ((this.causa==null && other.getCausa()==null) || 
             (this.causa!=null &&
              this.causa.equals(other.getCausa()))) &&
            ((this.monto==null && other.getMonto()==null) || 
             (this.monto!=null &&
              this.monto.equals(other.getMonto()))) &&
            this.secuencial == other.getSecuencial() &&
            this.plazo == other.getPlazo() &&
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
        if (getCuenta() != null) {
            _hashCode += getCuenta().hashCode();
        }
        if (getAccion() != null) {
            _hashCode += getAccion().hashCode();
        }
        if (getCausa() != null) {
            _hashCode += getCausa().hashCode();
        }
        if (getMonto() != null) {
            _hashCode += getMonto().hashCode();
        }
        _hashCode += getSecuencial();
        _hashCode += getPlazo();
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
        new org.apache.axis.description.TypeDesc(BloqDes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">bloqDes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuenta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cuenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "accion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("causa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "causa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "monto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secuencial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "secuencial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plazo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "plazo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
