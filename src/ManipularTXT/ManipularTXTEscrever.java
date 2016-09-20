/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManipularTXT;

import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Rodrigo
 */
public class ManipularTXTEscrever {
    public static void main(String args[]){
        try{
            FileOutputStream arquivo = new FileOutputStream("setting.txt");
            PrintWriter pr = new PrintWriter(arquivo);
            
            pr.println("localhost");
            pr.println("financeiroteste");
            pr.println("sa");
            pr.println("123654");
            
            pr.close();
            arquivo.close();
        
        }catch(Exception e){
            System.out.println("Erro"+e);
        }
    }
}
