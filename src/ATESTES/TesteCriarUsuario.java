/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATESTES;

import Criptografia.CriptografiaMD5;
import DAO.LOGIN_DAO;
import Entidades.Usuario;

/**
 *
 * @author Rodrigo
 */
public class TesteCriarUsuario {
    public static void main (String args[]){
        CriptografiaMD5 criptografar = new CriptografiaMD5();
        Usuario usuario = new Usuario();
        LOGIN_DAO dao = new LOGIN_DAO();
        String login = "admin";
        String senha = "admin";
        int nivel = 999;             
        //senha = criptografar.stringToMD5(senha);
        usuario.setLogin(login);
        usuario.setSenha(senha);
       // System.out.println(usuario.getSenha());
        usuario.setNivel(nivel);
        dao.Salvar(usuario);
        
    }
}
