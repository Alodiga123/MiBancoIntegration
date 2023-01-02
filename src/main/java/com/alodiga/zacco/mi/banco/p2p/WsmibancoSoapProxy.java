package com.alodiga.zacco.mi.banco.p2p;



public class WsmibancoSoapProxy implements WsmibancoSoap {
  private String _endpoint = null;
  private WsmibancoSoap wsmibancoSoap = null;
  
  public WsmibancoSoapProxy() {
    _initWsmibancoSoapProxy();
  }
  
  public WsmibancoSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWsmibancoSoapProxy();
  }
  
  private void _initWsmibancoSoapProxy() {
    try {
      wsmibancoSoap = (new WsmibancoLocator()).getwsmibancoSoap();
      if (wsmibancoSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wsmibancoSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wsmibancoSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wsmibancoSoap != null)
      ((javax.xml.rpc.Stub)wsmibancoSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public WsmibancoSoap getWsmibancoSoap() {
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap;
  }
  
  public CceResponse consulta_p2P(java.lang.String telefono_origen, int referencia, java.lang.String apikey, java.lang.String firma) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.consulta_p2P(telefono_origen, referencia, apikey, firma);
  }
  
  public Productos productosbancarios(java.lang.String apiKey, java.lang.String firma, java.lang.String id) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.productosbancarios(apiKey, firma, id);
  }
  
  public MibancoResponse p2P(java.lang.String operacion, java.lang.String telefono_origen, java.lang.String cedula_origen, java.lang.String telefono_destino, java.lang.String cedula, java.lang.String banco, java.math.BigDecimal monto, java.lang.String concepto, int referencia, java.lang.String causa, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.p2P(operacion, telefono_origen, cedula_origen, telefono_destino, cedula, banco, monto, concepto, referencia, causa, apiKey, firma);
  }
  
  public MibancoResponse ncnd(java.lang.String operacion, java.lang.String cuentaDestino, java.lang.String causa, java.math.BigDecimal monto, java.lang.String concepto, int referencia, java.lang.String apiKey, java.lang.String firma, java.math.BigDecimal tasa) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.ncnd(operacion, cuentaDestino, causa, monto, concepto, referencia, apiKey, firma, tasa);
  }
  
  public RespuestaTransferencia transferencia(java.lang.String operacion, java.lang.String cuentaOrigen, java.lang.String cuentaDestino, java.lang.String cedula, java.lang.String benificiario, java.math.BigDecimal monto, java.lang.String concepto, java.lang.String causa_debito, java.lang.String causa_credito, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.transferencia(operacion, cuentaOrigen, cuentaDestino, cedula, benificiario, monto, concepto, causa_debito, causa_credito, apiKey, firma);
  }
  
  public Mov movimientos(java.lang.String apiKey, java.lang.String firma, java.lang.String cuenta) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.movimientos(apiKey, firma, cuenta);
  }
  
  public RespuestaVuelto reversoVuelto(java.lang.String referencia, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.reversoVuelto(referencia, apiKey, firma);
  }
  
  public RespuestaVuelto vuelto(java.lang.String cedula, java.math.BigDecimal monto, java.lang.String causa, java.lang.String rif, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.vuelto(cedula, monto, causa, rif, apiKey, firma);
  }
  
  public RespuestaRecarga anulaRecarga(java.lang.String referencia, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.anulaRecarga(referencia, apiKey, firma);
  }
  
  public RespuestaRecarga recarga(java.lang.String cedula, java.math.BigDecimal monto, java.lang.String causa, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.recarga(cedula, monto, causa, apiKey, firma);
  }
  
  public SimfRespuestaValidacionLBTR simfLiquidacionLBTR(java.lang.String lclInstrm, java.lang.String endToEndId, java.lang.String channel, java.lang.String txStst, java.math.BigDecimal amt, java.lang.String ccy, java.lang.String purp, java.lang.String dbtrAgt, java.lang.String cdtrAgt, java.lang.String dbtrNm, java.lang.String dbtrId, java.lang.String dbtrSchmeNm, java.lang.String dbtrAcctTp, java.lang.String dbtrAcctId, java.lang.String dbtrAgtAcctTp, java.lang.String dbtrAgtAcctId, java.lang.String cdtrNm, java.lang.String cdtrId, java.lang.String cdtrSchmeNm, java.lang.String cdtrAcctTp, java.lang.String cdtrAcctId, java.lang.String cdtrAgtAcctTp, java.lang.String cdtrAgtAcctId, java.lang.String rmtInf, java.lang.String rsn) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.simfLiquidacionLBTR(lclInstrm, endToEndId, channel, txStst, amt, ccy, purp, dbtrAgt, cdtrAgt, dbtrNm, dbtrId, dbtrSchmeNm, dbtrAcctTp, dbtrAcctId, dbtrAgtAcctTp, dbtrAgtAcctId, cdtrNm, cdtrId, cdtrSchmeNm, cdtrAcctTp, cdtrAcctId, cdtrAgtAcctTp, cdtrAgtAcctId, rmtInf, rsn);
  }
  
  public SimfRespuestaValidacionLBTR simfValidacionLBTR(java.lang.String lclInstrm, java.lang.String endToEndId, java.lang.String channel, java.math.BigDecimal amt, java.lang.String ccy, java.lang.String purp, java.lang.String dbtrAgt, java.lang.String cdtrAgt, java.lang.String dbtrNm, java.lang.String dbtrId, java.lang.String dbtrSchmeNm, java.lang.String dbtrAcctTp, java.lang.String dbtrAcctId, java.lang.String dbtrAgtAcctTp, java.lang.String dbtrAgtAcctId, java.lang.String cdtrNm, java.lang.String cdtrId, java.lang.String cdtrSchmeNm, java.lang.String cdtrAcctTp, java.lang.String cdtrAcctId, java.lang.String cdtrAgtAcctTp, java.lang.String cdtrAgtAcctId) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.simfValidacionLBTR(lclInstrm, endToEndId, channel, amt, ccy, purp, dbtrAgt, cdtrAgt, dbtrNm, dbtrId, dbtrSchmeNm, dbtrAcctTp, dbtrAcctId, dbtrAgtAcctTp, dbtrAgtAcctId, cdtrNm, cdtrId, cdtrSchmeNm, cdtrAcctTp, cdtrAcctId, cdtrAgtAcctTp, cdtrAgtAcctId);
  }
  
  public SimfRespuestaValidacion simfLiquidacion(java.lang.String lclInstrm, java.lang.String endToEndId, java.lang.String channel, java.lang.String txStst, java.math.BigDecimal amt, java.lang.String ccy, java.lang.String dbtrAgt, java.lang.String cdtrAgt, java.lang.String dbtrId, java.lang.String dbtrSchmeNm, java.lang.String dbtrAcctTp, java.lang.String dbtrAcctId, java.lang.String cdtrId, java.lang.String cdtrSchmeNm, java.lang.String cdtrAcctTp, java.lang.String cdtrAcctId, java.lang.String dbtrNm, java.lang.String cdtrNm, java.lang.String rmtInf, java.lang.String addtlInf, java.lang.String rsn, java.lang.String orgnlTxId, java.lang.String clrSysRef, java.lang.String purp) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.simfLiquidacion(lclInstrm, endToEndId, channel, txStst, amt, ccy, dbtrAgt, cdtrAgt, dbtrId, dbtrSchmeNm, dbtrAcctTp, dbtrAcctId, cdtrId, cdtrSchmeNm, cdtrAcctTp, cdtrAcctId, dbtrNm, cdtrNm, rmtInf, addtlInf, rsn, orgnlTxId, clrSysRef, purp);
  }
  
  public SimfRespuestaValidacion simfValidacion(java.lang.String lclInstrm, java.lang.String endToEndId, java.lang.String channel, java.math.BigDecimal amt, java.lang.String ccy, java.lang.String dbtrAgt, java.lang.String cdtrAgt, java.lang.String dbtrId, java.lang.String dbtrSchmeNm, java.lang.String dbtrAcctTp, java.lang.String dbtrAcctId, java.lang.String cdtrId, java.lang.String cdtrSchmeNm, java.lang.String cdtrAcctTp, java.lang.String cdtrAcctId, java.lang.String dbtrNm, java.lang.String cdtrNm, java.lang.String orgnlTxId, java.lang.String orgnlEndToEndId, java.lang.String addtlInf, java.lang.String clrSysRef, java.lang.String purp, RfrdDocInf rfrdDocInf) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.simfValidacion(lclInstrm, endToEndId, channel, amt, ccy, dbtrAgt, cdtrAgt, dbtrId, dbtrSchmeNm, dbtrAcctTp, dbtrAcctId, cdtrId, cdtrSchmeNm, cdtrAcctTp, cdtrAcctId, dbtrNm, cdtrNm, orgnlTxId, orgnlEndToEndId, addtlInf, clrSysRef, purp, rfrdDocInf);
  }
  
  public TfResponse tfConsultaPago(java.lang.String fecha, java.lang.String codigoBanco, java.lang.String ctadeb, java.lang.String referencia) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.tfConsultaPago(fecha, codigoBanco, ctadeb, referencia);
  }
  
  public TfResponse tfPago(java.lang.String fecha, java.lang.String dnideb, java.lang.String ctadeb, java.lang.String codigoBancoCredito, java.lang.String dnicre, java.lang.String nomcre, java.lang.String ctacre, java.lang.String motcre, java.lang.String mondeb, java.lang.String moncre, java.math.BigDecimal monto, java.lang.String referencia, java.lang.String firma, java.lang.String apiKey) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.tfPago(fecha, dnideb, ctadeb, codigoBancoCredito, dnicre, nomcre, ctacre, motcre, mondeb, moncre, monto, referencia, firma, apiKey);
  }
  
  public MibancoResponse setZelleMoney(java.lang.String id, java.math.BigDecimal monto, java.lang.String nombre, java.lang.String mensaje, java.lang.String correo) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.setZelleMoney(id, monto, nombre, mensaje, correo);
  }
  
  public MibancoResponse setMoneyToCta(java.lang.String id, java.math.BigDecimal monto, java.lang.String cedula, java.lang.String nombre) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.setMoneyToCta(id, monto, cedula, nombre);
  }
  
  public java.lang.String getCtaMoney(java.lang.String id) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.getCtaMoney(id);
  }
  
  public Respuesta getMsg(java.lang.String celular, java.lang.String canal, java.lang.String msg, java.lang.String hash, java.lang.String referencia) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.getMsg(celular, canal, msg, hash, referencia);
  }
  
  public MibancoResponse bloqDes(java.lang.String cuenta, java.lang.String accion, java.lang.String causa, java.math.BigDecimal monto, int secuencial, int plazo, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.bloqDes(cuenta, accion, causa, monto, secuencial, plazo, apiKey, firma);
  }
  
  public MibancoResponse getPosicionDivisa(int moneda) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.getPosicionDivisa(moneda);
  }
  
  public ClientResponse getInforCliente(java.lang.String numIdentificacion, java.lang.String secuencial, java.lang.String apiKey, java.lang.String firma) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.getInforCliente(numIdentificacion, secuencial, apiKey, firma);
  }
  
  public java.lang.String digest(java.lang.String datos, java.lang.String secreto) throws java.rmi.RemoteException{
    if (wsmibancoSoap == null)
      _initWsmibancoSoapProxy();
    return wsmibancoSoap.digest(datos, secreto);
  }
  
  
}