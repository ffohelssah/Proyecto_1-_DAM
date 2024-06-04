package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.usuario;


public class daousuarios {
	
	private Connection con = null;
    private static daousuarios instance = null; 

    /**
     * método que nos conecta con la Base de datos llamando al método getConnection de la clase ConxionBD, si la conexion es nula, establece una nueva conexión.
     * @throws SQLException lanza un error tipo SQL si hubiese algun error conectando a la BBDD
     */
    
    public daousuarios() throws SQLException {
        if(con==null) {
            con = DBConnection.getConnection();
        }
    }

    /**
     * Este método implementa el patrón Singleton,Si no existiera crearía una llamada daousuarios para conectarlo a la base de datos.
     * @return instance devuelve daousuarios
     * @throws SQLException lanza un error tipo SQL si hubiese algun error conectando a la BBDD
     */
    public static daousuarios getInstance() throws SQLException {

        if(instance==null) {
            instance = new daousuarios();
        }
        return instance;
    }
    
	/**
	 * 
	 * @param a
	 * @throws SQLException
	 */
	public void insertar(usuario a) throws SQLException {
		
	PreparedStatement ps = con.prepareStatement
	("INSERT into usuario (nombre,contrasenia,email,IDpermiso) VALUES (?,?,?,?)");
    ps.setString(1, a.getUsuario());
    ps.setString(2, a.getContrasenia());
	ps.setString(3, a.getEmail());
	ps.setInt(4, a.getPermiso());
		
    ps.executeUpdate();
		
	ps.close();
		
	}
	/**
	 * 
	 * @param u
	 * @throws SQLException
	 */
	public void actualizar(usuario a) throws SQLException {
		String sql = "UPDATE usuario SET nombre=?,contrasenia=?,email=?,IDpermiso=? WHERE IDusuario=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, a.getUsuario());
	    ps.setString(2, a.getContrasenia());
		ps.setString(3, a.getEmail());
		ps.setInt(4, a.getPermiso());
		ps.setInt(5, a.getId());
			
	    ps.executeUpdate();
			
		ps.close();
	}
	
	public void borrar(int id) throws SQLException {
		String sql = "DELETE FROM usuario WHERE IDusuario=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		
	}
	/**
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public usuario obtenerporid(int id) throws SQLException  {
		String sql = "SELECT * FROM usuario WHERE IDusuario=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		usuario u = new usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
		
		return u;
	}
    public usuario logeando(usuario u, String contrasenia) throws SQLException {
    	String sql = "SELECT * FROM usuario WHERE email=? AND contrasenia=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getEmail());
		ps.setString(2, contrasenia);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		usuario a = new usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
		
		return a;
    }
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<usuario> listar() throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario");
		ResultSet rs = ps.executeQuery();
		
		ArrayList<usuario> result = null;
		
		while(rs.next()) {
			
			if(result == null) {
				result = new ArrayList<usuario>();
			}
			result.add(new usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
		}
		
		
		return result;
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String dameJson() throws SQLException {
		
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar());
		
		return json;
	}
	
	

}
