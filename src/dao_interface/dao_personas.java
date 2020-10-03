package dao_interface;
import entidad.Personas;

import java.util.ArrayList;

import dao.DAO_Personas;

public interface dao_personas {
	
	public int AgrerarUsuario (Personas personas);
	public Personas Obtener_usuario (String dni);
	public ArrayList<Personas> Obtener_lista_usuarios();
	
	
}
