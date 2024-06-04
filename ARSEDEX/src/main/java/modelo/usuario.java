package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.daousuarios;

public class usuario {
	
	private int id;
	private String usuario;
	private String email;
	private String contrasenia;
	private int permiso;
	
	
	/**
	 * Constructor para generar un objeto vacio de tipo usuario
	 */
	public usuario() {
		
	}
	
	/**
	 * Contructor para creación del objeto desde el formulario
	 * @param usuario Atributo solo texto
	 * @param contrasenia Atributo solo texto. lo he llamado contraseña como podría ser direccion u otra cosa, esto no es una contraseña persé porque no puede ir aquí por proteccion de datos
	 * @param email Atributo solo texto
	 * @param permiso Atributo solo numerico
	 */
	public usuario(String usuario, String contrasenia, String email, int permiso) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.email = email;
		this.permiso = permiso;
	}
	
	/**
	 * Constructor para creación del objeto desde el formulario
	 * @param id Atributo solo numerico
	 * @param usuario Atributo solo texto
	 * @param contrasenia Atributo solo texto. lo he llamado contraseña como podría ser direccion u otra cosa, esto no es una contraseña persé porque no puede ir aquí por proteccion de datos
	 * @param email Atributo solo texto
	 * @param permiso Atributo solo numerico
	 */
	public usuario(int id, String usuario, String contrasenia, String email, int permiso) {
		this.id = id;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.email = email;
		this.permiso = permiso;
	}
	
	/**
	 * metodo de inclusion del id en el objeto
	 * @return retorna el id en tipo entero
	 */
	public int getId() {
		return id;
	}
    
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return 
	 */
	public String getUsuario() {
		return usuario;
	}
/**
 * 
 * @param usuario
 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * 
	 * @return
	 */
	public String getContrasenia() {
		return contrasenia;
	}
/**
 * 
 * @param contrasenia
 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

/**
 * 
 * @return
 */
	public String getEmail() {
		return email;
	}
/**
 * 
 * @param email
 */
	public void setEmail(String email) {
		this.email = email;
	}
/**
 * 
 * @return
 */
	public int getPermiso() {
		return permiso;
	}
/**
 * 
 * @param permiso
 */
	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}
	
/**
 * Método toString
 */
	@Override
	public String toString() {
		return "usuario [id=" + id + ", usuario=" + usuario + ", email=" + email + ", permiso=" + permiso + "]";
	}

	
/**
 * Conexión con el apartado de insertar para el dao
 * @throws SQLException
 */
	public void insertar() throws SQLException {
		daousuarios dao = new daousuarios();
		dao.insertar(this);
		
		daousuarios.getInstance().insertar(this);
		
	}
	/**
	 * borrar
	 * @param id
	 * @throws SQLException
	 */
	public void borrar(int id) throws SQLException {
		
		daousuarios.getInstance().borrar(id);
	}
	/**
	 * actualizar
	 * @throws SQLException
	 */
	public void update() throws SQLException {
		
		daousuarios.getInstance().actualizar(this);
		
	}
	/**
	 * obtención del ID de las tablas
	 * @param id
	 * @throws SQLException
	 */
	public void obtenerporid(int id) throws SQLException {
		
		daousuarios dao = new daousuarios();
		usuario u = dao.obtenerporid(id);
		
		this.setId(u.getId());
		this.setUsuario(u.getUsuario());
		this.setContrasenia(u.getContrasenia());
		this.setEmail(u.getEmail());
		this.setPermiso(u.getPermiso());
	}
	/**
	 * Apartado del logeo
	 * @param contrasenia
	 * @return
	 * @throws SQLException
	 */
	public boolean logeo(String contrasenia) throws SQLException {
		
		boolean ok = false;
		
		daousuarios dao = new daousuarios();
		usuario u = dao.logeando(this, contrasenia); // bd
		
		if(u != null) {
			ok=true;
			this.setId(u.getId());
			this.setUsuario(u.getUsuario());
			this.setContrasenia(u.getContrasenia());
			this.setEmail(u.getEmail());
			this.setPermiso(u.getPermiso());
		}
		
				
		return ok;
	}
	/**
	 * aplicación y búsquyeda del Gson y Json
	 * @return
	 */
	public String dameJson() {
		String json = "";
		
		Gson gson = new Gson();
		
		json = gson.toJson(this);
		
		return json;
		
	}
	
}
