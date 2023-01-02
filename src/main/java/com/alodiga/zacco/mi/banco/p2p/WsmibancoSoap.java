/**
 * WsmibancoSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.alodiga.zacco.mi.banco.p2p;



public interface WsmibancoSoap extends java.rmi.Remote {
    public CceResponse consulta_p2P(java.lang.String telefono_origen, int referencia, java.lang.String apikey, java.lang.String firma) throws java.rmi.RemoteException;
    public Productos productosbancarios(java.lang.String apiKey, java.lang.String firma, java.lang.String id) throws java.rmi.RemoteException;
    public MibancoResponse p2P(java.lang.String operacion, java.lang.String telefono_origen, java.lang.String cedula_origen, java.lang.String telefono_destino, java.lang.String cedula, java.lang.String banco, java.math.BigDecimal monto, java.lang.String concepto, int referencia, java.lang.String causa, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException;
    public MibancoResponse ncnd(java.lang.String operacion, java.lang.String cuentaDestino, java.lang.String causa, java.math.BigDecimal monto, java.lang.String concepto, int referencia, java.lang.String apiKey, java.lang.String firma, java.math.BigDecimal tasa) throws java.rmi.RemoteException;
    public RespuestaTransferencia transferencia(java.lang.String operacion, java.lang.String cuentaOrigen, java.lang.String cuentaDestino, java.lang.String cedula, java.lang.String benificiario, java.math.BigDecimal monto, java.lang.String concepto, java.lang.String causa_debito, java.lang.String causa_credito, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException;
    public Mov movimientos(java.lang.String apiKey, java.lang.String firma, java.lang.String cuenta) throws java.rmi.RemoteException;
    public RespuestaVuelto reversoVuelto(java.lang.String referencia, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException;
    public RespuestaVuelto vuelto(java.lang.String cedula, java.math.BigDecimal monto, java.lang.String causa, java.lang.String rif, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException;
    public RespuestaRecarga anulaRecarga(java.lang.String referencia, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException;
    public RespuestaRecarga recarga(java.lang.String cedula, java.math.BigDecimal monto, java.lang.String causa, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException;
    public SimfRespuestaValidacionLBTR simfLiquidacionLBTR(java.lang.String lclInstrm, java.lang.String endToEndId, java.lang.String channel, java.lang.String txStst, java.math.BigDecimal amt, java.lang.String ccy, java.lang.String purp, java.lang.String dbtrAgt, java.lang.String cdtrAgt, java.lang.String dbtrNm, java.lang.String dbtrId, java.lang.String dbtrSchmeNm, java.lang.String dbtrAcctTp, java.lang.String dbtrAcctId, java.lang.String dbtrAgtAcctTp, java.lang.String dbtrAgtAcctId, java.lang.String cdtrNm, java.lang.String cdtrId, java.lang.String cdtrSchmeNm, java.lang.String cdtrAcctTp, java.lang.String cdtrAcctId, java.lang.String cdtrAgtAcctTp, java.lang.String cdtrAgtAcctId, java.lang.String rmtInf, java.lang.String rsn) throws java.rmi.RemoteException;
    public SimfRespuestaValidacionLBTR simfValidacionLBTR(java.lang.String lclInstrm, java.lang.String endToEndId, java.lang.String channel, java.math.BigDecimal amt, java.lang.String ccy, java.lang.String purp, java.lang.String dbtrAgt, java.lang.String cdtrAgt, java.lang.String dbtrNm, java.lang.String dbtrId, java.lang.String dbtrSchmeNm, java.lang.String dbtrAcctTp, java.lang.String dbtrAcctId, java.lang.String dbtrAgtAcctTp, java.lang.String dbtrAgtAcctId, java.lang.String cdtrNm, java.lang.String cdtrId, java.lang.String cdtrSchmeNm, java.lang.String cdtrAcctTp, java.lang.String cdtrAcctId, java.lang.String cdtrAgtAcctTp, java.lang.String cdtrAgtAcctId) throws java.rmi.RemoteException;
    public SimfRespuestaValidacion simfLiquidacion(java.lang.String lclInstrm, java.lang.String endToEndId, java.lang.String channel, java.lang.String txStst, java.math.BigDecimal amt, java.lang.String ccy, java.lang.String dbtrAgt, java.lang.String cdtrAgt, java.lang.String dbtrId, java.lang.String dbtrSchmeNm, java.lang.String dbtrAcctTp, java.lang.String dbtrAcctId, java.lang.String cdtrId, java.lang.String cdtrSchmeNm, java.lang.String cdtrAcctTp, java.lang.String cdtrAcctId, java.lang.String dbtrNm, java.lang.String cdtrNm, java.lang.String rmtInf, java.lang.String addtlInf, java.lang.String rsn, java.lang.String orgnlTxId, java.lang.String clrSysRef, java.lang.String purp) throws java.rmi.RemoteException;
    public SimfRespuestaValidacion simfValidacion(java.lang.String lclInstrm, java.lang.String endToEndId, java.lang.String channel, java.math.BigDecimal amt, java.lang.String ccy, java.lang.String dbtrAgt, java.lang.String cdtrAgt, java.lang.String dbtrId, java.lang.String dbtrSchmeNm, java.lang.String dbtrAcctTp, java.lang.String dbtrAcctId, java.lang.String cdtrId, java.lang.String cdtrSchmeNm, java.lang.String cdtrAcctTp, java.lang.String cdtrAcctId, java.lang.String dbtrNm, java.lang.String cdtrNm, java.lang.String orgnlTxId, java.lang.String orgnlEndToEndId, java.lang.String addtlInf, java.lang.String clrSysRef, java.lang.String purp, RfrdDocInf rfrdDocInf) throws java.rmi.RemoteException;
    public TfResponse tfConsultaPago(java.lang.String fecha, java.lang.String codigoBanco, java.lang.String ctadeb, java.lang.String referencia) throws java.rmi.RemoteException;
    public TfResponse tfPago(java.lang.String fecha, java.lang.String dnideb, java.lang.String ctadeb, java.lang.String codigoBancoCredito, java.lang.String dnicre, java.lang.String nomcre, java.lang.String ctacre, java.lang.String motcre, java.lang.String mondeb, java.lang.String moncre, java.math.BigDecimal monto, java.lang.String referencia, java.lang.String firma, java.lang.String apiKey) throws java.rmi.RemoteException;
    public MibancoResponse setZelleMoney(java.lang.String id, java.math.BigDecimal monto, java.lang.String nombre, java.lang.String mensaje, java.lang.String correo) throws java.rmi.RemoteException;
    public MibancoResponse setMoneyToCta(java.lang.String id, java.math.BigDecimal monto, java.lang.String cedula, java.lang.String nombre) throws java.rmi.RemoteException;
    public java.lang.String getCtaMoney(java.lang.String id) throws java.rmi.RemoteException;
    public Respuesta getMsg(java.lang.String celular, java.lang.String canal, java.lang.String msg, java.lang.String hash, java.lang.String referencia) throws java.rmi.RemoteException;
    public MibancoResponse bloqDes(java.lang.String cuenta, java.lang.String accion, java.lang.String causa, java.math.BigDecimal monto, int secuencial, int plazo, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException;
    public MibancoResponse getPosicionDivisa(int moneda) throws java.rmi.RemoteException;
    public ClientResponse getInforCliente(java.lang.String numIdentificacion, java.lang.String secuencial, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException;
    public java.lang.String digest(java.lang.String datos, java.lang.String secreto) throws java.rmi.RemoteException;
}
