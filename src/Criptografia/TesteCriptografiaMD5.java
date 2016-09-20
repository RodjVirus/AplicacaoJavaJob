/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Criptografia;

/**
 *
 * @author Rodrigo
 */
public class TesteCriptografiaMD5 {
    public static void main(String args[]){
        CriptografiaMD5 criptografia = new CriptografiaMD5();
        String senha = "teste";
        String salt = "!@#$%¨";
        System.out.println("Senha Sem Criptografia: "+senha);
        senha = criptografia.stringToMD5(senha+salt);
        System.out.println("Senha Com Criptografia: "+senha);  
    }
}
