package sv.com.empresa.Tienda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import sv.com.empresa.Tienda.entidades.Usuarios;

public class UsuariosDAO {
	private EntityManagerFactory emf;
	
	public UsuariosDAO (EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public List<Usuarios> listar () {
		EntityManager em = emf.createEntityManager();
		
		List<Usuarios> listado = em.createQuery("SELECT u FROM Usuarios u", Usuarios.class).getResultList();
		
		em.close();
		
		return listado;
	}
}