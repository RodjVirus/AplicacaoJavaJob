package Conexao;


import DAO.ConfiguracaoBanco;
import Entidades.BancoDeDados;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static JPAUtil jpaUtil;
	private EntityManagerFactory emf;
        ConfiguracaoBanco lerSettingTxt = new ConfiguracaoBanco(); 
        BancoDeDados info = lerSettingTxt.Buscar();   
        
        
        
	public JPAUtil() {                
		Map<String, Object> configuracao = new HashMap<String, Object>();
		configuracao.put("javax.persistence.jdbc.url", "jdbc:sqlserver://"+info.getIp()+":"+info.getPorta()+";databaseName="+info.getBanco());//verificar a melhor forma como vc vai passar os parametros, banco, usuario, senha
		configuracao.put("javax.persistence.jdbc.user", info.getLogin());
                configuracao.put("javax.persistence.jdbc.driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		configuracao.put("javax.persistence.jdbc.password", info.getSenha());
                configuracao.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
                configuracao.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
                configuracao.put("hibernate.show_sql", "true");
                configuracao.put("hibernate.format_sql", "true");
                configuracao.put("hibernate.hbm2ddl.auto", "update");
                
		emf = Persistence.createEntityManagerFactory("persistenciaTeste", configuracao);
	}
	public static JPAUtil getInstance(BancoDeDados info) {
		if (jpaUtil == null) {
			jpaUtil = new JPAUtil();
		}
		return jpaUtil;
	}
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	public void finalizar(){
		this.emf = null;
	}
}