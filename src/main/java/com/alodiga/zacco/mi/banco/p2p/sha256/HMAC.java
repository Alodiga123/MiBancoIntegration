/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alodiga.zacco.mi.banco.p2p.sha256;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author dlugo
 */
public class HMAC {
    static public byte[] calcHmacSha256(byte[] secretKey, byte[] message) {
    byte[] hmacSha256 = null;
    try {
      Mac mac = Mac.getInstance("HmacSHA256");
      SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "HmacSHA256");
      mac.init(secretKeySpec);
      hmacSha256 = mac.doFinal(message);
    } catch (Exception e) {
      throw new RuntimeException("Failed to calculate hmac-sha256", e);
    }
    return hmacSha256;
  }
    
}
