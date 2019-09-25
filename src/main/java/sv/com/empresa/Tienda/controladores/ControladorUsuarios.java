package sv.com.empresa.Tienda.controladores;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Persistence;

import sv.com.empresa.Tienda.dao.UsuariosDAO;
import sv.com.empresa.Tienda.entidades.Usuarios;

@ManagedBean(name = "usuariosMB")
@RequestScoped
public class ControladorUsuarios {
	private Usuarios usuario;
	private UsuariosDAO usuarioDAO;
	
	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public ControladorUsuarios () {
		usuarioDAO = new UsuariosDAO(Persistence.createEntityManagerFactory("TiendaPU"));
		usuario = new Usuarios();
	}
	
	public String validar () {
		List<Usuarios> lista = usuarioDAO.listar();
		
		for (Usuarios u : lista) {
			if (usuario.getUsuario().equals(u.getUsuario()) && usuario.getClave().equals(u.getClave())) {
				usuario = u;
				return "/faces/bienvenida.xhtml";
			}
		}
		
		return null;
	}
}