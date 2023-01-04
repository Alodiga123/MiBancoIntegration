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
		 MibancoResponse mibancoResponse =  main.p2pRecharge("04264161684", 123, "V10271776", "0169", new BigDecimal("10.0"));
		 System.out.println("Estatus:"+mibancoResponse.getEstatus());
		 System.out.println("Mensaje:"+mibancoResponse.getMensaje());
		 System.out.println("referencia:"+mibancoResponse.getReferencia());
	 }
    
    public static MibancoResponse p2pRecharge(String destinationPhoneNumber, Integer referenceNumber,String destionationIdentificationNumber, String destionationAbaBank, BigDecimal amount) {
    	
    	//Datos de la transaccion
        String Telefono_origen = "04242526894"; //Constante
        String Cedula_origen = "J000572500"; //Constante 
        String secretKey = "a3856cc20d1ec77d8f51083f147577e1";//Constante
        String apiKeys = "1eb06174bfaa4dbd80a3a46903dbb704";//Constante
        WsmibancoSoapProxy proxy = new WsmibancoSoapProxy();
        MibancoResponse mibancoResponse = new MibancoResponse();
        
        
        String Telefono_destino = "04264161684";
        String Cedula = "V10271776";
        String Banco = "0169";

        
        
        
        
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
            mibancoResponse = proxy.p2P("I", Telefono_origen,
                    Cedula_origen, Telefono_destino, Cedula,Banco, 
                    amount, "Prueba CT", referenceNumber, Causa,
                    apiKeys,
                    FirmaXML);

            System.out.println("Mensaje: " + mibancoResponse.getMensaje());
            System.out.println("Status: " + mibancoResponse.getEstatus());
            System.out.println("Referencia: " + mibancoResponse.getReferencia());
            
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
