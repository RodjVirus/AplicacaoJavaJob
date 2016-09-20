/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManipularTXT;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Rodrigo
 */
public class ManipularTXTLer {
        public static void main(String args[]){
        try{
            FileInputStream arquivo = new FileInputStream("setting.txt");
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader br       = new BufferedReader(input);
            
            String linha;            
            
            do{
                linha = br.readLine();
                if(linha!=null){
                    System.out.println("Lido: "+linha);
                }
            }while(linha!=null);
        }catch(Exception e){
            System.out.println("Erro"+e);
        }
    }
}
