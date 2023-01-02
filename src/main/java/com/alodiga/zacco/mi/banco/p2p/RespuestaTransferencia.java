/**
 * RespuestaTransferencia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.alodiga.zacco.mi.banco.p2p;



public class RespuestaTransferencia  implements java.io.Serializable {
    private java.lang.String codigo;

    private java.lang.String mensaje;

    private java.lang.String referencia;

    private java.math.BigDecimal tasa;

    private java.math.BigDecimal comision;

    private java.math.BigDecimal monto_debito;

    private java.math.BigDecimal monto_credito;

    private java.math.BigDecimal monto_diferido;

    private java.lang.String moneda_debito;

    private java.lang.String moneda_credito;

    public RespuestaTransferencia() {
    }

    public RespuestaTransferencia(
           java.lang.String codigo,
           java.lang.String mensaje,
           java.lang.String referencia,
           java.math.BigDecimal tasa,
           java.math.BigDecimal comision,
           java.math.BigDecimal monto_debito,
           java.math.BigDecimal monto_credito,
           java.math.BigDecimal monto_diferido,
           java.lang.String moneda_debito,
           java.lang.String moneda_credito) {
           this.codigo = codigo;
           this.mensaje = mensaje;
           this.referencia = referencia;
           this.tasa = tasa;
           this.comision = comision;
           this.monto_debito = monto_debito;
           this.monto_credito = monto_credito;
           this.monto_diferido = monto_diferido;
           this.moneda_debito = moneda_debito;
           this.moneda_credito = moneda_credito;
    }


    /**
     * Gets the codigo value for this RespuestaTransferencia.
     * 
     * @return codigo
     */
    public java.lang.String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this RespuestaTransferencia.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the mensaje value for this RespuestaTransferencia.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this RespuestaTransferencia.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the referencia value for this RespuestaTransferencia.
     * 
     * @return referencia
     */
    public java.lang.String getReferencia() {
        return referencia;
    }


    /**
     * Sets the referencia value for this RespuestaTransferencia.
     * 
     * @param referencia
     */
    public void setReferencia(java.lang.String referencia) {
        this.referencia = referencia;
    }


    /**
     * Gets the tasa value for this RespuestaTransferencia.
     * 
     * @return tasa
     */
    public java.math.BigDecimal getTasa() {
        return tasa;
    }


    /**
     * Sets the tasa value for this RespuestaTransferencia.
     * 
     * @param tasa
     */
    public void setTasa(java.math.BigDecimal tasa) {
        this.tasa = tasa;
    }


    /**
     * Gets the comision value for this RespuestaTransferencia.
     * 
     * @return comision
     */
    public java.math.BigDecimal getComision() {
        return comision;
    }


    /**
     * Sets the comision value for this RespuestaTransferencia.
     * 
     * @param comision
     */
    public void setComision(java.math.BigDecimal comision) {
        this.comision = comision;
    }


    /**
     * Gets the monto_debito value for this RespuestaTransferencia.
     * 
     * @return monto_debito
     */
    public java.math.BigDecimal getMonto_debito() {
        return monto_debito;
    }


    /**
     * Sets the monto_debito value for this RespuestaTransferencia.
     * 
     * @param monto_debito
     */
    public void setMonto_debito(java.math.BigDecimal monto_debito) {
        this.monto_debito = monto_debito;
    }


    /**
     * Gets the monto_credito value for this RespuestaTransferencia.
     * 
     * @return monto_credito
     */
    public java.math.BigDecimal getMonto_credito() {
        return monto_credito;
    }


    /**
     * Sets the monto_credito value for this RespuestaTransferencia.
     * 
     * @param monto_credito
     */
    public void setMonto_credito(java.math.BigDecimal monto_credito) {
        this.monto_credito = monto_credito;
    }


    /**
     * Gets the monto_diferido value for this RespuestaTransferencia.
     * 
     * @return monto_diferido
     */
    public java.math.BigDecimal getMonto_diferido() {
        return monto_diferido;
    }


    /**
     * Sets the monto_diferido value for this RespuestaTransferencia.
     * 
     * @param monto_diferido
     */
    public void setMonto_diferido(java.math.BigDecimal monto_diferido) {
        this.monto_diferido = monto_diferido;
    }


    /**
     * Gets the moneda_debito value for this RespuestaTransferencia.
     * 
     * @return moneda_debito
     */
    public java.lang.String getMoneda_debito() {
        return moneda_debito;
    }


    /**
     * Sets the moneda_debito value for this RespuestaTransferencia.
     * 
     * @param moneda_debito
     */
    public void setMoneda_debito(java.lang.String moneda_debito) {
        this.moneda_debito = moneda_debito;
    }


    /**
     * Gets the moneda_credito value for this RespuestaTransferencia.
     * 
     * @return moneda_credito
     */
    public java.lang.String getMoneda_credito() {
        return moneda_credito;
    }


    /**
     * Sets the moneda_credito value for this RespuestaTransferencia.
     * 
     * @param moneda_credito
     */
    public void setMoneda_credito(java.lang.String moneda_credito) {
        this.moneda_credito = moneda_credito;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaTransferencia)) return false;
        RespuestaTransferencia other = (RespuestaTransferencia) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje()))) &&
            ((this.referencia==null && other.getReferencia()==null) || 
             (this.referencia!=null &&
              this.referencia.equals(other.getReferencia()))) &&
            ((this.tasa==null && other.getTasa()==null) || 
             (this.tasa!=null &&
              this.tasa.equals(other.getTasa()))) &&
            ((this.comision==null && other.getComision()==null) || 
             (this.comision!=null &&
              this.comision.equals(other.getComision()))) &&
            ((this.monto_debito==null && other.getMonto_debito()==null) || 
             (this.monto_debito!=null &&
              this.monto_debito.equals(other.getMonto_debito()))) &&
            ((this.monto_credito==null && other.getMonto_credito()==null) || 
             (this.monto_credito!=null &&
              this.monto_credito.equals(other.getMonto_credito()))) &&
            ((this.monto_diferido==null && other.getMonto_diferido()==null) || 
             (this.monto_diferido!=null &&
              this.monto_diferido.equals(other.getMonto_diferido()))) &&
            ((this.moneda_debito==null && other.getMoneda_debito()==null) || 
             (this.moneda_debito!=null &&
              this.moneda_debito.equals(other.getMoneda_debito()))) &&
            ((this.moneda_credito==null && other.getMoneda_credito()==null) || 
             (this.moneda_credito!=null &&
              this.moneda_credito.equals(other.getMoneda_credito())));
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
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        if (getReferencia() != null) {
            _hashCode += getReferencia().hashCode();
        }
        if (getTasa() != null) {
            _hashCode += getTasa().hashCode();
        }
        if (getComision() != null) {
            _hashCode += getComision().hashCode();
        }
        if (getMonto_debito() != null) {
            _hashCode += getMonto_debito().hashCode();
        }
        if (getMonto_credito() != null) {
            _hashCode += getMonto_credito().hashCode();
        }
        if (getMonto_diferido() != null) {
            _hashCode += getMonto_diferido().hashCode();
        }
        if (getMoneda_debito() != null) {
            _hashCode += getMoneda_debito().hashCode();
        }
        if (getMoneda_credito() != null) {
            _hashCode += getMoneda_credito().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaTransferencia.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "RespuestaTransferencia"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "mensaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "referencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tasa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "tasa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comision");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "comision"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monto_debito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "monto_debito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monto_credito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "monto_credito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monto_diferido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "monto_diferido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moneda_debito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "moneda_debito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moneda_credito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "moneda_credito"));
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
