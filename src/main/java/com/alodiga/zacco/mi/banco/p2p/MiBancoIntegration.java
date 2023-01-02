/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.alodiga.zacco.mi.banco.p2p;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerwin
 */
public class MiBancoIntegration {
    public static void main(String[] args) {
        System.out.println("prueba");
        WsmibancoSoapProxy proxy = new WsmibancoSoapProxy();
        MibancoResponse mibancoResponse = new MibancoResponse();
        BigDecimal amount = new BigDecimal(3.85);
        int reference = 12207615;
        try {
            mibancoResponse = proxy.p2P("I", "04242526894", "J000572500", "041227", "V10271776", "0169", amount, "Prueba CT", reference, "777", "c9e6c0bd12ada87a076b122b868885a1", "6bc30b68d48ad1bef67c9d910b23235fa9f2643bc12f385e0eafaec182647402");
            System.out.println(mibancoResponse.getMensaje());
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
