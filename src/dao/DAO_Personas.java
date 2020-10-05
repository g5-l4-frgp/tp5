package dao;
import dao_interface.dao_personas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidad.Personas;

public class DAO_Personas implements dao_personas{
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "ROOT";
	private String dbName = "bdpersonas";
	
	public DAO_Personas() {
		
	}
	
	public int AgrerarUsuario (Personas personas) {
		
		String quety = "Insert into personas (Nombre, Apellido, Dni) values ('" + personas.getDni() + "', '" + personas.getNombre() + "', '" + personas.getApellido() + "')";
		Connection cn = null;
		int filas=0;
		
		try{
			
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(quety);
			
		}
		catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return filas;
		
	}
	
	
	public Personas Obtener_usuario (String dni) {
		
		Personas x = new Personas();
		
		Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			String query = "Select * from personas where dni = '" + dni + "'";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			x.setNombre(rs.getString("Nombre"));
			x.setApellido(rs.getString("Apellido"));
			x.setDni(rs.getString("dni"));
			
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return x;
		
	}
	
public ArrayList<Personas> Obtener_lista_usuarios () {
		
		ArrayList<Personas> x = new ArrayList<Personas>();
		
		Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			String query = "Select * from personas";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				Personas aux = new Personas();
				aux.setNombre(rs.getString("Nombre"));
				aux.setApellido(rs.getString("Apellido"));
				aux.setDni(rs.getString("dni"));
				x.add(aux);
				
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return x;
		
	}

public boolean EliminarPersona (String dni) {
	
	String query = "Delete from Personas where Dni = '" + dni +"'";
	Connection cn = null;
		
	try{
		
		cn = DriverManager.getConnection(host+dbName, user, pass);
		Statement st = cn.createStatement();
		 st.executeUpdate(query);
		
	}
	catch(Exception e){
		
		e.printStackTrace();
		return false; 
	}
	
	return true ;
}


}

