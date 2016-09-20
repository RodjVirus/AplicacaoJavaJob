/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Criptografia;
import org.apache.commons.codec.binary.Base64;


/**
 *
 * @author Rodrigo
 */
public class CriptografiaBase64 {
    
    public String Criptografar(String string){
        Base64 base = new Base64();
        string = base.encodeBase64String(string.getBytes());       
           
        return string;
    }
    
    public String Descriptografar(String string){
        byte[] decoded = Base64.decodeBase64(string);       
        
        String stringDecoded = new String(decoded);
        
        
        return stringDecoded;
    }
    
}
