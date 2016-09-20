/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Criptografia;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CriptografiaMD5 {
   public String stringToMD5(String string){
        String md5 = null;
                if(string == null){
                    return null;
                }                
            MessageDigest digest;                
       try {
           digest = MessageDigest.getInstance("MD5");
           digest.update(string.getBytes(), 0, string.length());
           md5 = new BigInteger(1, digest.digest()).toString(16);
       } catch (NoSuchAlgorithmException ex) {
           Logger.getLogger(CriptografiaMD5.class.getName()).log(Level.SEVERE, null, ex);
       }                
                return md5;                
}
   
   //public String MD5ToString(String string){
  //     return null;
  // }
}


































