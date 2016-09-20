/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Conexao.JPAUtil;
import Entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;


/**
 *
 * @author Rodrigo
 */
public class LOGIN_DAO {
        	
    
    	EntityManagerFactory emf;
	EntityManager em;
        
	JPAUtil jpateste = new JPAUtil();
	public LOGIN_DAO(){
		em = jpateste.getEntityManager();
	}
        
	public Usuario obterPorId(int id){
		em.getTransaction().begin();
		Usuario usuario = em.find(Usuario.class, id);
		em.getTransaction().commit();
		
		return usuario;
	}
	
	public void Salvar(Usuario usuario){
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
                em.close();
	}	


        public List<Usuario> listarTodos(){         
           
            Query q = em.createQuery("select object(u) from Usuario u ");
        
            @SuppressWarnings("unchecked")
        
                    List<Usuario> usuarios = q.getResultList();
            
            return usuarios;
        }
        

            
	public List<Usuario> listarPorCod(Integer usuario_busca){
            
            
            Query query = em.createQuery("SELECT t FROM Produtos t WHERE t.produto_COD = :palavra");  
        
            query.setParameter("palavra", usuario_busca);
            
            List<Usuario> retorno = query.getResultList();
            
            return retorno;
        }    
        
        public void apagar(Usuario usuario){
            em.getTransaction().begin();
            Usuario u = em.find(Usuario.class, usuario.getId());
            em.remove(u);
            em.getTransaction().commit();
        }
        
	public List<Usuario> listarPorNome(String usuario_busca){
            
            
            Query query = em.createQuery("SELECT t FROM Produtos t WHERE t.produto_nome LIKE :palavra");  
        
            query.setParameter("palavra", "%" + usuario_busca + "%");
            
            List<Usuario> retorno = query.getResultList();
            
            return retorno;
        }        
	

        public Usuario DevolverDadosLogin(String usuario, String senha){
            Usuario dadosLogin = new Usuario();          
            try{
                Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.login LIKE :login AND u.senha LIKE :senha");
                query.setParameter("login", usuario);
                query.setParameter("senha", senha);
                List<Usuario> busca = query.getResultList();
                if(!busca.isEmpty()){
                    dadosLogin.setLogin(busca.get(0).getLogin().trim());
                    dadosLogin.setNivel(busca.get(0).getNivel());
                }                
            }catch(Exception error){
                JOptionPane.showConfirmDialog(null, error);
            }
            em.close();
            return dadosLogin;
        }

   
    
    
}
