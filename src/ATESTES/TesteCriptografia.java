/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATESTES;

import Criptografia.CriptografiaBase64;
import Entidades.BancoDeDados;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Rodrigo
 */
public class TesteCriptografia {
    public static void main(String[] args){
        try{CriptografiaBase64 criptografia = new CriptografiaBase64();
        String criptografar, criptografado, descriptografado;
        BancoDeDados informacoes = new BancoDeDados();
                    FileInputStream arquivo = new FileInputStream("setting.txt");
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader br       = new BufferedReader(input);
            
            informacoes.setIp(criptografia.Descriptografar(br.readLine().trim()));                                //ip
            informacoes.setBanco(criptografia.Descriptografar(br.readLine().trim()));                                //banco 
            informacoes.setLogin(criptografia.Descriptografar(br.readLine().trim()));                                //login 
            informacoes.setSenha(criptografia.Descriptografar(br.readLine().trim()));                                //senha
            System.out.println(informacoes.getIp());
            System.out.println(informacoes.getBanco());
            System.out.println(informacoes.getLogin());
            System.out.println(informacoes.getSenha());
            
        }catch(Exception erro){
            System.out.println(erro);
        }
    }
}
