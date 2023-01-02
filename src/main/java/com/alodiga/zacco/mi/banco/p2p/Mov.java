/**
 * Mov.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.alodiga.zacco.mi.banco.p2p;



public class Mov  implements java.io.Serializable {
    private java.lang.String saldo;

    private Movimiento[] movimientos;

    private java.lang.String codigo;

    private java.lang.String mensaje;

    public Mov() {
    }

    public Mov(
           java.lang.String saldo,
           Movimiento[] movimientos,
           java.lang.String codigo,
           java.lang.String mensaje) {
           this.saldo = saldo;
           this.movimientos = movimientos;
           this.codigo = codigo;
           this.mensaje = mensaje;
    }


    /**
     * Gets the saldo value for this Mov.
     * 
     * @return saldo
     */
    public java.lang.String getSaldo() {
        return saldo;
    }


    /**
     * Sets the saldo value for this Mov.
     * 
     * @param saldo
     */
    public void setSaldo(java.lang.String saldo) {
        this.saldo = saldo;
    }


    /**
     * Gets the movimientos value for this Mov.
     * 
     * @return movimientos
     */
    public Movimiento[] getMovimientos() {
        return movimientos;
    }


    /**
     * Sets the movimientos value for this Mov.
     * 
     * @param movimientos
     */
    public void setMovimientos(Movimiento[] movimientos) {
        this.movimientos = movimientos;
    }


    /**
     * Gets the codigo value for this Mov.
     * 
     * @return codigo
     */
    public java.lang.String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this Mov.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the mensaje value for this Mov.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this Mov.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Mov)) return false;
        Mov other = (Mov) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.saldo==null && other.getSaldo()==null) || 
             (this.saldo!=null &&
              this.saldo.equals(other.getSaldo()))) &&
            ((this.movimientos==null && other.getMovimientos()==null) || 
             (this.movimientos!=null &&
              java.util.Arrays.equals(this.movimientos, other.getMovimientos()))) &&
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje())));
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
        if (getSaldo() != null) {
            _hashCode += getSaldo().hashCode();
        }
        if (getMovimientos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMovimientos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMovimientos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Mov.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "mov"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saldo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "saldo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("movimientos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "movimientos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "movimiento"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://tempuri.org/", "movimiento"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
