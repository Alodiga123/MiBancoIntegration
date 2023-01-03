package com.alodiga.zacco.mi.banco.p2p;

import com.alodiga.zacco.mi.banco.p2p.sha256.HMAC;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerwin
 */
public class MiBancoIntegration {
    public static void main(String[] args) throws UnsupportedEncodingException {   
        
        String secretKey = "a3856cc20d1ec77d8f51083f147577e1";
        String apiKeys = "1eb06174bfaa4dbd80a3a46903dbb704";

        WsmibancoSoapProxy proxy = new WsmibancoSoapProxy();
        MibancoResponse mibancoResponse = new MibancoResponse();
        
        //Datos de la transaccion
        String Telefono_origen = "04242526894";
        String Cedula_origen = "J000572500";
        String Telefono_destino = "04264161684";
        String Cedula = "V10271776";
        String Banco = "0169";
        BigDecimal amount = new BigDecimal("3.85");
        int reference = 12207617;
        String Causa = "777";

        String firmar = Telefono_destino + amount + reference;
        System.out.println("Firmar: " +firmar);

        byte[] firma = HMAC.calcHmacSha256(secretKey.getBytes("UTF-8"), firmar.getBytes("UTF-8"));
        
        
        String FirmaXML = String.format("%064x", new BigInteger(1, firma));

        System.out.println("FirmaXML: "+FirmaXML);

        try {
            mibancoResponse = proxy.p2P("I", Telefono_origen,
                    Cedula_origen, Telefono_destino, Cedula,Banco, 
                    amount, "Prueba CT", reference, Causa,
                    apiKeys,
                    FirmaXML);

            System.out.println("Mensaje: " + mibancoResponse.getMensaje());
            System.out.println("Status: " + mibancoResponse.getEstatus());
            System.out.println("Referencia: " + mibancoResponse.getReferencia());
            
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
