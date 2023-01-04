package com.alodiga.zacco.mi.banco.p2p;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;

import com.alodiga.zacco.mi.banco.p2p.sha256.HMAC;
import com.alodiga.zacco.mi.banco.p2p.util.CodigoRespuesta;
import com.alodiga.zacco.mi.banco.p2p.util.Constant;

/**
 *
 * @author kerwin
 */
public class MiBancoIntegration {
	
	 public static void main(String[] args) throws Exception {
		 MiBancoIntegration main = new MiBancoIntegration();
		 MibancoResponse mibancoResponse =  main.p2pRecharge("04122788693", 123456, "V10271776", "0169", new BigDecimal("10.0"),"RETIRO PERSONAL ZACCO");
		 System.out.println("Estatus:"+mibancoResponse.getEstatus());
		 System.out.println("Mensaje:"+mibancoResponse.getMensaje());
		 System.out.println("referencia:"+mibancoResponse.getReferencia());
	 }
    
    public static MibancoResponse p2pRecharge(String destinationPhoneNumber, Integer referenceNumber,String destionationIdentificationNumber, String destionationAbaBank, BigDecimal amount, String concept) {
    	//Datos de la transaccion
        WsmibancoSoapProxy proxy = new WsmibancoSoapProxy();
        MibancoResponse mibancoResponse = new MibancoResponse();
        String Causa = "777";
        String firmar = destinationPhoneNumber + amount + referenceNumber;
        byte[] firma;
		try {
			firma = HMAC.calcHmacSha256(Constant.API_SECRET.getBytes("UTF-8"), firmar.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			mibancoResponse.setEstatus(CodigoRespuesta.ERROR_INTERNO.getCodigo());
        	mibancoResponse.setMensaje(CodigoRespuesta.ERROR_INTERNO.name());
        	return mibancoResponse;
		}
        String FirmaXML = String.format("%064x", new BigInteger(1, firma));
        try {
            mibancoResponse = proxy.p2P("I", Constant.SOURCE_PHONE_NUMBER,
                    Constant.SOURCE_IDENTIFICATION_NUMBER, destinationPhoneNumber, destionationIdentificationNumber,destionationAbaBank, 
                    amount, concept, referenceNumber, Causa,
                    Constant.API_KEY,
                    FirmaXML);
        } catch (RemoteException ex) {
        	mibancoResponse.setEstatus(CodigoRespuesta.ERROR_INTERNO.getCodigo());
        	mibancoResponse.setMensaje(CodigoRespuesta.ERROR_INTERNO.name());
        } catch (Exception ex) {
        	ex.printStackTrace();
        	mibancoResponse.setEstatus(CodigoRespuesta.ERROR_INTERNO.getCodigo());
        	mibancoResponse.setMensaje(CodigoRespuesta.ERROR_INTERNO.name());
        }
    	return mibancoResponse;
    }
}
