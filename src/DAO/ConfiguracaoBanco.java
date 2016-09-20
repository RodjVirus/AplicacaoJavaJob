/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Criptografia.CriptografiaBase64;
import Entidades.BancoDeDados;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Rodrigo
 */
public class ConfiguracaoBanco {
    public void Atualizar(BancoDeDados info){
        try{
            FileOutputStream arquivo = new FileOutputStream("setting.txt");
            PrintWriter pr = new PrintWriter(arquivo);
            
            pr.println(info.getIp());
            pr.println(info.getBanco());
            pr.println(info.getLogin());
            pr.println(info.getSenha());
            pr.println(info.getPorta());
            
            pr.close();
            arquivo.close();
        
        }catch(Exception e){
            System.out.println("Erro"+e);
        }
            
    }
    
    public BancoDeDados Buscar(){
        BancoDeDados informacoes = new BancoDeDados();
        CriptografiaBase64 criptografia = new CriptografiaBase64();
        try{
            FileInputStream arquivo = new FileInputStream("setting.txt");
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader br       = new BufferedReader(input);
            
            
            informacoes.setIp(criptografia.Descriptografar(br.readLine().trim()));                                //ip
            informacoes.setBanco(criptografia.Descriptografar(br.readLine().trim()));                                //banco 
            informacoes.setLogin(criptografia.Descriptografar(br.readLine().trim()));                                //login 
            informacoes.setSenha(criptografia.Descriptografar(br.readLine().trim()));                                //senha
            informacoes.setPorta(criptografia.Descriptografar(br.readLine().trim()));                               //porta
            
        }catch(Exception e){
            System.out.println("Erro"+e);
        }       
        
        return informacoes;
    }
}
